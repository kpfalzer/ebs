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

package ebs.type;

import ebs.Random;

import java.util.BitSet;

import static gblibx.Util.downcast;
import static gblibx.Util.invariant;

public class BitVector extends BitSet {
    public int toInt() {
        invariant(length() <= Integer.SIZE);
        return downcast(toLongArray()[0]);
    }

    public long toLong() {
        invariant(length() <= Long.SIZE);
        return toLongArray()[0];
    }

    public BitVector valueOf(int v) {
        return valueOf(Integer.toUnsignedLong(v));
    }

    public BitVector valueOf(long v) {
        invariant(length() <= Long.SIZE);
        for (int i = 0; i < length(); ++i) {
            boolean b = (0 != (0x01 & v));
            set(i, b);
            v = v >> 1;
        }
        return this;
    }

    private BitVector(int nbits) {
        super(nbits);
    }

    public static <T extends BitVector> T create(int nbits) {
        return downcast(new BitVector(nbits));
    }

    public static <T extends BitVector> T random(int nbits) {
        T res = BitVector.create(nbits);
        for (int i = 0; i < nbits; ++i) {
            res.set(i, Random.theOne().nextBoolean());
        }
        return res;
    }

    public static class N1 extends BitVector {
        public N1() {
            super(1);
        }
    }

    public static class N2 extends BitVector {
        public N2() {
            super(2);
        }
    }

    public static class N3 extends BitVector {
        public N3() {
            super(3);
        }
    }

    public static class N4 extends BitVector {
        public N4() {
            super(4);
        }
    }

    public static class N5 extends BitVector {
        public N5() {
            super(5);
        }
    }

    public static class N6 extends BitVector {
        public N6() {
            super(6);
        }
    }

    public static class N7 extends BitVector {
        public N7() {
            super(7);
        }
    }

    public static class N8 extends BitVector {
        public N8() {
            super(8);
        }
    }

    public static class N9 extends BitVector {
        public N9() {
            super(9);
        }
    }

    public static class N10 extends BitVector {
        public N10() {
            super(10);
        }
    }

    public static class N11 extends BitVector {
        public N11() {
            super(11);
        }
    }

    public static class N12 extends BitVector {
        public N12() {
            super(12);
        }
    }

    public static class N13 extends BitVector {
        public N13() {
            super(13);
        }
    }

    public static class N14 extends BitVector {
        public N14() {
            super(14);
        }
    }

    public static class N15 extends BitVector {
        public N15() {
            super(15);
        }
    }

    public static class N16 extends BitVector {
        public N16() {
            super(16);
        }
    }

    public static class N17 extends BitVector {
        public N17() {
            super(17);
        }
    }

    public static class N18 extends BitVector {
        public N18() {
            super(18);
        }
    }

    public static class N19 extends BitVector {
        public N19() {
            super(19);
        }
    }

    public static class N20 extends BitVector {
        public N20() {
            super(20);
        }
    }

    public static class N21 extends BitVector {
        public N21() {
            super(21);
        }
    }

    public static class N22 extends BitVector {
        public N22() {
            super(22);
        }
    }

    public static class N23 extends BitVector {
        public N23() {
            super(23);
        }
    }

    public static class N24 extends BitVector {
        public N24() {
            super(24);
        }
    }

    public static class N25 extends BitVector {
        public N25() {
            super(25);
        }
    }

    public static class N26 extends BitVector {
        public N26() {
            super(26);
        }
    }

    public static class N27 extends BitVector {
        public N27() {
            super(27);
        }
    }

    public static class N28 extends BitVector {
        public N28() {
            super(28);
        }
    }

    public static class N29 extends BitVector {
        public N29() {
            super(29);
        }
    }

    public static class N30 extends BitVector {
        public N30() {
            super(30);
        }
    }

    public static class N31 extends BitVector {
        public N31() {
            super(31);
        }
    }

    public static class N32 extends BitVector {
        public N32() {
            super(32);
        }
    }

    public static class N33 extends BitVector {
        public N33() {
            super(33);
        }
    }

    public static class N34 extends BitVector {
        public N34() {
            super(34);
        }
    }

    public static class N35 extends BitVector {
        public N35() {
            super(35);
        }
    }

    public static class N36 extends BitVector {
        public N36() {
            super(36);
        }
    }

    public static class N37 extends BitVector {
        public N37() {
            super(37);
        }
    }

    public static class N38 extends BitVector {
        public N38() {
            super(38);
        }
    }

    public static class N39 extends BitVector {
        public N39() {
            super(39);
        }
    }

    public static class N40 extends BitVector {
        public N40() {
            super(40);
        }
    }

    public static class N41 extends BitVector {
        public N41() {
            super(41);
        }
    }

    public static class N42 extends BitVector {
        public N42() {
            super(42);
        }
    }

    public static class N43 extends BitVector {
        public N43() {
            super(43);
        }
    }

    public static class N44 extends BitVector {
        public N44() {
            super(44);
        }
    }

    public static class N45 extends BitVector {
        public N45() {
            super(45);
        }
    }

    public static class N46 extends BitVector {
        public N46() {
            super(46);
        }
    }

    public static class N47 extends BitVector {
        public N47() {
            super(47);
        }
    }

    public static class N48 extends BitVector {
        public N48() {
            super(48);
        }
    }

    public static class N49 extends BitVector {
        public N49() {
            super(49);
        }
    }

    public static class N50 extends BitVector {
        public N50() {
            super(50);
        }
    }

    public static class N51 extends BitVector {
        public N51() {
            super(51);
        }
    }

    public static class N52 extends BitVector {
        public N52() {
            super(52);
        }
    }

    public static class N53 extends BitVector {
        public N53() {
            super(53);
        }
    }

    public static class N54 extends BitVector {
        public N54() {
            super(54);
        }
    }

    public static class N55 extends BitVector {
        public N55() {
            super(55);
        }
    }

    public static class N56 extends BitVector {
        public N56() {
            super(56);
        }
    }

    public static class N57 extends BitVector {
        public N57() {
            super(57);
        }
    }

    public static class N58 extends BitVector {
        public N58() {
            super(58);
        }
    }

    public static class N59 extends BitVector {
        public N59() {
            super(59);
        }
    }

    public static class N60 extends BitVector {
        public N60() {
            super(60);
        }
    }

    public static class N61 extends BitVector {
        public N61() {
            super(61);
        }
    }

    public static class N62 extends BitVector {
        public N62() {
            super(62);
        }
    }

    public static class N63 extends BitVector {
        public N63() {
            super(63);
        }
    }

    public static class N64 extends BitVector {
        public N64() {
            super(64);
        }
    }
}
