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

import ebs.type.IntSignal;
import org.junit.jupiter.api.Test;

import static ebs.Util.eval;
import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    static final int T = 10;
    State<Boolean> clk = new State<>(true);
    State<Integer> a = new State<>(0),
            b = new State<>(0),
            c = new State<>(0);
    Output<Integer> z = new Output<>();
    IntSignal aPlusB = new IntSignal();
    Process p1, p2, p3, p4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 = new Process(a, b) {
            @Override
            public void process() {
                aPlusB.set(a.get() + b.get());
            }
        };
        p2 = new Process(aPlusB, c) {
            @Override
            public void process() {
                //z.set(eval(aPlusB.get(), c.get(), (a,b)-> a+b));
                z.set(aPlusB.get() + c.get());
            }
        };
        p3 = new Process(clk) {
            @Override
            public void process() {
                clk.set(T, !clk.get());
            }
        };
        p4 = new Process(clk) {
            @Override
            public void process() {
                a.set(a.get() + 1);
                b.set(b.get() + 2);
                c.set(c.get() + 3);
            }
        };
        //initial
        clk.set(0, true);
    }

    @Test
    void process() {
        long end = TimeWheel.run((cb) -> {
            String ts = cb.getTime();
            long now = cb.now();
            int z = this.z.get();
            int aPlusB = this.aPlusB.get();
        });
        System.out.println("end time=" + end);
    }
}