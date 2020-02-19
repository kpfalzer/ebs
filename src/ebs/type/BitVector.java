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

import static gblibx.Util.downcast;
import static gblibx.Util.invariant;

public abstract class BitVector {
    public int toInt() {
        invariant(nbits() <= Integer.SIZE);
        return (int) toLong();
    }

    public long toLong() {
        invariant(nbits() <= Long.SIZE);
        return __val & _andMask();
    }

    public BitVector valueOf(int v) {
        return valueOf(Integer.toUnsignedLong(v));
    }

    public BitVector valueOf(long v) {
        __val = v & _andMask();
        return this;
    }

    public boolean set(int i, boolean val) {
        assert (i >= 0) && (i < nbits());
        if (val) __val |= (0x01 << i);
        else __val &= ~(0x01 << i);
        return val;
    }

    private long __val = 0;

    public abstract int nbits();

    protected abstract long _andMask();

    private BitVector() {
        __val = (Random.theOne().nextLong() & _andMask());
    }

    public static class N1 extends BitVector {
        public N1() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 1;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N2 extends BitVector {
        public N2() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 2;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N3 extends BitVector {
        public N3() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 3;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N4 extends BitVector {
        public N4() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 4;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N5 extends BitVector {
        public N5() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 5;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N6 extends BitVector {
        public N6() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 6;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N7 extends BitVector {
        public N7() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 7;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N8 extends BitVector {
        public N8() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 8;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N9 extends BitVector {
        public N9() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 9;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N10 extends BitVector {
        public N10() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 10;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N11 extends BitVector {
        public N11() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 11;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N12 extends BitVector {
        public N12() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 12;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N13 extends BitVector {
        public N13() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 13;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N14 extends BitVector {
        public N14() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 14;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N15 extends BitVector {
        public N15() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 15;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N16 extends BitVector {
        public N16() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 16;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N17 extends BitVector {
        public N17() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 17;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N18 extends BitVector {
        public N18() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 18;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N19 extends BitVector {
        public N19() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 19;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N20 extends BitVector {
        public N20() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 20;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N21 extends BitVector {
        public N21() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 21;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N22 extends BitVector {
        public N22() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 22;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N23 extends BitVector {
        public N23() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 23;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N24 extends BitVector {
        public N24() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 24;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N25 extends BitVector {
        public N25() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 25;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N26 extends BitVector {
        public N26() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 26;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N27 extends BitVector {
        public N27() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 27;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N28 extends BitVector {
        public N28() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 28;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N29 extends BitVector {
        public N29() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 29;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N30 extends BitVector {
        public N30() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 30;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N31 extends BitVector {
        public N31() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 31;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N32 extends BitVector {
        public N32() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 32;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N33 extends BitVector {
        public N33() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 33;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N34 extends BitVector {
        public N34() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 34;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N35 extends BitVector {
        public N35() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 35;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N36 extends BitVector {
        public N36() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 36;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N37 extends BitVector {
        public N37() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 37;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N38 extends BitVector {
        public N38() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 38;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N39 extends BitVector {
        public N39() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 39;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N40 extends BitVector {
        public N40() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 40;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N41 extends BitVector {
        public N41() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 41;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N42 extends BitVector {
        public N42() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 42;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N43 extends BitVector {
        public N43() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 43;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N44 extends BitVector {
        public N44() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 44;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N45 extends BitVector {
        public N45() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 45;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N46 extends BitVector {
        public N46() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 46;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N47 extends BitVector {
        public N47() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 47;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N48 extends BitVector {
        public N48() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 48;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N49 extends BitVector {
        public N49() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 49;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N50 extends BitVector {
        public N50() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 50;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N51 extends BitVector {
        public N51() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 51;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N52 extends BitVector {
        public N52() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 52;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N53 extends BitVector {
        public N53() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 53;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N54 extends BitVector {
        public N54() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 54;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N55 extends BitVector {
        public N55() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 55;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N56 extends BitVector {
        public N56() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 56;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N57 extends BitVector {
        public N57() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 57;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N58 extends BitVector {
        public N58() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 58;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N59 extends BitVector {
        public N59() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 59;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N60 extends BitVector {
        public N60() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 60;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N61 extends BitVector {
        public N61() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 61;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N62 extends BitVector {
        public N62() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 62;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N63 extends BitVector {
        public N63() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 63;
        private static final long __AND_MASK = ~(~0 << __N);
    }
    public static class N64 extends BitVector {
        public N64() {
            super();
        }

        @Override
        public int nbits() {
            return __N;
        }

        @Override
        protected long _andMask() {
            return __AND_MASK;
        }

        private static final int __N = 64;
        private static final long __AND_MASK = ~(~0 << __N);
    }
}
