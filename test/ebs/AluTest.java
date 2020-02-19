/*
 *
 *  * The MIT License
 *  *
 *  * Copyright 2020 kpfalzer.
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in
 *  * all copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 *
 *
 */

package ebs;

import ebs.type.*;
import org.junit.jupiter.api.Test;

import static gblibx.Util.invariant;

class AluTest {

    static final int T = 10;

    BoolState clk = new BoolState(true);
    final Process osc = new Process(clk) {
        @Override
        public void process() {
            clk.set(T, !clk.get());
        }
    };

    static class Regfile2R1W<TADDR extends BitVector> {
        Regfile2R1W(Input<Boolean> clk,
                    Input<Boolean> wen0, Input<TADDR> waddr0, Input<Integer> din0,
                    Input<TADDR> raddr0, Output<Integer> dout0,
                    Input<TADDR> raddr1, Output<Integer> dout1
        ) {
            this.wen0 = wen0;
            this.waddr0 = waddr0;
            this.din0 = din0;
            this.raddr0 = raddr0;
            this.dout0.connect(dout0);
            this.raddr1 = raddr1;
            this.dout1.connect(dout1);
            __mem = new Integer[1 << this.waddr0.get().nbits()];
            __randomize();
            __p1 = new Process(clk) {
                @Override
                public void process() {
                    //read before write
                    dout0.set(__mem[raddr0.get().toInt()]);
                    dout1.set(__mem[raddr1.get().toInt()]);
                    if (wen0.get()) {
                        __mem[waddr0.get().toInt()] = din0.get();
                    }
                }
            };
        }

        private void __randomize() {
            for (int i = 0; i < __mem.length; ++i) {
                __mem[i] = Random.theOne().nextInt();
            }
        }

        private final Input<Boolean> wen0;
        private final Input<TADDR> waddr0;
        private final Input<Integer> din0;
        private final Input<TADDR> raddr0;
        private final IntState dout0 = new IntState();
        private final Input<TADDR> raddr1;
        private final IntState dout1 = new IntState();
        private final Integer[] __mem;
        private final Process __p1;
    }

    /*
     * ALU with registered z-output.
     */
    static class Alu {
        enum EOp {eAdd, eSub, eUnknown}

        ;

        static class EOpSignal extends Signal<EOp> {
            public EOp _getUninitialized() {
                return EOp.eUnknown;
            }
        }

        static class EOpState extends State<EOp> {
            public EOpState() {
                this(EOp.eUnknown);
            }

            public EOpState(EOp initial) {
                super(initial);
            }
        }

        Alu(Input<Boolean> clk, Input<EOp> opcode, Input<Integer> a, Input<Integer> b,
            Output<Integer> z) {
            this.opcode = opcode;
            this.a = a;
            this.b = b;
            this.z.connect(z);
            __p1 = new Process(clk) {
                @Override
                public void process() {
                    switch (opcode.get()) {
                        case eAdd:
                            z.set(a.get() + b.get());
                            break;
                        case eSub:
                            z.set(a.get() - b.get());
                            break;
                        default:
                            z.set(Random.theOne().nextInt());
                    }
                }
            };
        }

        private final Input<EOp> opcode;
        private final Input<Integer> a;
        private final Input<Integer> b;
        private final IntState z = new IntState();
        private final Process __p1;
    }

    // Encapsulate opcode
    static class Opcode {
        Opcode(Alu.EOp aluOp, boolean rfSelectImmed, boolean rfWen0,
               int rfWaddr0, int rfRaddr0, int rfAddr1, int immed) {
            this.aluOp = aluOp;
            this.rfSelectImmed = rfSelectImmed;
            this.rfWen0 = rfWen0;
            this.rfWaddr0 = rfWaddr0;
            this.rfRaddr0 = rfRaddr0;
            this.rfRaddr1 = rfAddr1;
            this.immed = immed;
        }

        final Alu.EOp aluOp;
        final boolean rfSelectImmed, rfWen0;
        final int rfWaddr0, rfRaddr0, rfRaddr1;
        final int immed;

        static class State extends ebs.State<Opcode> {
            private static Opcode __X = new Opcode(
                    Alu.EOp.eUnknown,
                    Random.theOne().nextBoolean(),
                    Random.theOne().nextBoolean(),
                    Random.theOne().nextInt(),
                    Random.theOne().nextInt(),
                    Random.theOne().nextInt(),
                    Random.theOne().nextInt()
            );

            public State(Opcode initial) {
                super(initial);
            }

            public State() {
                this(__X);
            }
        }
    }

    static final Opcode program[] = {
            new Opcode(Alu.EOp.eUnknown, true, true, 0, 0, 0, 1234),
            new Opcode(Alu.EOp.eUnknown, false, false, 0, 0, 0, 1234)

    };

    int pc = 0;

    class Dut {
        //use global clk: Input<Boolean> clk;

        Alu.EOpSignal aluOp = new Alu.EOpSignal();
        BoolSignal rfSelectImmed = new BoolSignal();
        BoolSignal rfWen0 = new BoolSignal();
        BitVectorSignal.N5 rfWaddr0 = new BitVectorSignal.N5();
        BitVectorSignal.N5 rfRaddr0 = new BitVectorSignal.N5();
        BitVectorSignal.N5 rfRaddr1 = new BitVectorSignal.N5();
        IntSignal immed = new IntSignal();
        //
        //connections
        IntSignal z = new IntSignal();
        IntSignal aluA = new IntSignal();
        IntSignal aluB = new IntSignal();

        // mux output: alu.z or immed
        IntSignal rfDin = new IntSignal();

        // opcode pipeline
        Opcode.State opcode = new Opcode.State();

        // instances
        Alu alu = new Alu(clk, aluOp, aluA, aluB, z);
        Regfile2R1W<BitVector.N5> rf = new Regfile2R1W<>(
                clk, rfWen0, rfWaddr0,
                rfDin, rfRaddr0, aluA, rfRaddr1, aluB);

        private BitVector.N5 __getAddr(int addr) {
            BitVector.N5 xaddr = new BitVector.N5();
            xaddr.valueOf(addr);
            return xaddr;
        }

        private void __apply(Opcode opcode) {
            aluOp.set(opcode.aluOp);
            rfSelectImmed.set(opcode.rfSelectImmed);
            rfWen0.set(opcode.rfWen0);
            rfWaddr0.set(__getAddr(opcode.rfWaddr0));
            rfRaddr0.set(__getAddr(opcode.rfRaddr0));
            rfRaddr1.set(__getAddr(opcode.rfRaddr1));
            immed.set(opcode.immed);
        }

        Process __p1 = new Process(clk) {
            @Override
            public void process() {
                __apply(opcode.get());
                rfDin.set((rfSelectImmed.get()) ? immed.get() : z.get());
                if (pc < program.length) {
                    opcode.set(program[pc]);
                    ++pc;
                }
            }
        };

    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //initial: 1st realQ event
        clk.set(0, true);
    }

    @Test
    void process() {
        final Dut dut = new Dut();
        long end = TimeWheel.run((cb) -> {
            String ts = cb.getTime();
            long now = cb.now();
            if (now > 100) TimeWheel.stop();
            boolean xbreak = true;
        });
        System.out.println("end time=" + end);
    }
}