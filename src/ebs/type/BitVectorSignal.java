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
import ebs.Signal;

public class BitVectorSignal<T extends BitVector> extends Signal<T> {
    protected T _getUninitialized(int nbits) {
        return BitVector.random(nbits);
    }

    public static class N1 extends BitVectorSignal<BitVector.N1> {
        public BitVector.N1 _getUninitialized() {
            return super._getUninitialized(1);
        }
    }

    public static class N2 extends BitVectorSignal<BitVector.N2> {
        public BitVector.N2 _getUninitialized() {
            return super._getUninitialized(2);
        }
    }

    public static class N3 extends BitVectorSignal<BitVector.N3> {
        public BitVector.N3 _getUninitialized() {
            return super._getUninitialized(3);
        }
    }

    public static class N4 extends BitVectorSignal<BitVector.N4> {
        public BitVector.N4 _getUninitialized() {
            return super._getUninitialized(4);
        }
    }

    public static class N5 extends BitVectorSignal<BitVector.N5> {
        public BitVector.N5 _getUninitialized() {
            return super._getUninitialized(5);
        }
    }

    public static class N6 extends BitVectorSignal<BitVector.N6> {
        public BitVector.N6 _getUninitialized() {
            return super._getUninitialized(6);
        }
    }

    public static class N7 extends BitVectorSignal<BitVector.N7> {
        public BitVector.N7 _getUninitialized() {
            return super._getUninitialized(7);
        }
    }

    public static class N8 extends BitVectorSignal<BitVector.N8> {
        public BitVector.N8 _getUninitialized() {
            return super._getUninitialized(8);
        }
    }

    public static class N9 extends BitVectorSignal<BitVector.N9> {
        public BitVector.N9 _getUninitialized() {
            return super._getUninitialized(9);
        }
    }

    public static class N10 extends BitVectorSignal<BitVector.N10> {
        public BitVector.N10 _getUninitialized() {
            return super._getUninitialized(10);
        }
    }

    public static class N11 extends BitVectorSignal<BitVector.N11> {
        public BitVector.N11 _getUninitialized() {
            return super._getUninitialized(11);
        }
    }

    public static class N12 extends BitVectorSignal<BitVector.N12> {
        public BitVector.N12 _getUninitialized() {
            return super._getUninitialized(12);
        }
    }

    public static class N13 extends BitVectorSignal<BitVector.N13> {
        public BitVector.N13 _getUninitialized() {
            return super._getUninitialized(13);
        }
    }

    public static class N14 extends BitVectorSignal<BitVector.N14> {
        public BitVector.N14 _getUninitialized() {
            return super._getUninitialized(14);
        }
    }

    public static class N15 extends BitVectorSignal<BitVector.N15> {
        public BitVector.N15 _getUninitialized() {
            return super._getUninitialized(15);
        }
    }

    public static class N16 extends BitVectorSignal<BitVector.N16> {
        public BitVector.N16 _getUninitialized() {
            return super._getUninitialized(16);
        }
    }

    public static class N17 extends BitVectorSignal<BitVector.N17> {
        public BitVector.N17 _getUninitialized() {
            return super._getUninitialized(17);
        }
    }

    public static class N18 extends BitVectorSignal<BitVector.N18> {
        public BitVector.N18 _getUninitialized() {
            return super._getUninitialized(18);
        }
    }

    public static class N19 extends BitVectorSignal<BitVector.N19> {
        public BitVector.N19 _getUninitialized() {
            return super._getUninitialized(19);
        }
    }

    public static class N20 extends BitVectorSignal<BitVector.N20> {
        public BitVector.N20 _getUninitialized() {
            return super._getUninitialized(20);
        }
    }

    public static class N21 extends BitVectorSignal<BitVector.N21> {
        public BitVector.N21 _getUninitialized() {
            return super._getUninitialized(21);
        }
    }

    public static class N22 extends BitVectorSignal<BitVector.N22> {
        public BitVector.N22 _getUninitialized() {
            return super._getUninitialized(22);
        }
    }

    public static class N23 extends BitVectorSignal<BitVector.N23> {
        public BitVector.N23 _getUninitialized() {
            return super._getUninitialized(23);
        }
    }

    public static class N24 extends BitVectorSignal<BitVector.N24> {
        public BitVector.N24 _getUninitialized() {
            return super._getUninitialized(24);
        }
    }

    public static class N25 extends BitVectorSignal<BitVector.N25> {
        public BitVector.N25 _getUninitialized() {
            return super._getUninitialized(25);
        }
    }

    public static class N26 extends BitVectorSignal<BitVector.N26> {
        public BitVector.N26 _getUninitialized() {
            return super._getUninitialized(26);
        }
    }

    public static class N27 extends BitVectorSignal<BitVector.N27> {
        public BitVector.N27 _getUninitialized() {
            return super._getUninitialized(27);
        }
    }

    public static class N28 extends BitVectorSignal<BitVector.N28> {
        public BitVector.N28 _getUninitialized() {
            return super._getUninitialized(28);
        }
    }

    public static class N29 extends BitVectorSignal<BitVector.N29> {
        public BitVector.N29 _getUninitialized() {
            return super._getUninitialized(29);
        }
    }

    public static class N30 extends BitVectorSignal<BitVector.N30> {
        public BitVector.N30 _getUninitialized() {
            return super._getUninitialized(30);
        }
    }

    public static class N31 extends BitVectorSignal<BitVector.N31> {
        public BitVector.N31 _getUninitialized() {
            return super._getUninitialized(31);
        }
    }

    public static class N32 extends BitVectorSignal<BitVector.N32> {
        public BitVector.N32 _getUninitialized() {
            return super._getUninitialized(32);
        }
    }

    public static class N33 extends BitVectorSignal<BitVector.N33> {
        public BitVector.N33 _getUninitialized() {
            return super._getUninitialized(33);
        }
    }

    public static class N34 extends BitVectorSignal<BitVector.N34> {
        public BitVector.N34 _getUninitialized() {
            return super._getUninitialized(34);
        }
    }

    public static class N35 extends BitVectorSignal<BitVector.N35> {
        public BitVector.N35 _getUninitialized() {
            return super._getUninitialized(35);
        }
    }

    public static class N36 extends BitVectorSignal<BitVector.N36> {
        public BitVector.N36 _getUninitialized() {
            return super._getUninitialized(36);
        }
    }

    public static class N37 extends BitVectorSignal<BitVector.N37> {
        public BitVector.N37 _getUninitialized() {
            return super._getUninitialized(37);
        }
    }

    public static class N38 extends BitVectorSignal<BitVector.N38> {
        public BitVector.N38 _getUninitialized() {
            return super._getUninitialized(38);
        }
    }

    public static class N39 extends BitVectorSignal<BitVector.N39> {
        public BitVector.N39 _getUninitialized() {
            return super._getUninitialized(39);
        }
    }

    public static class N40 extends BitVectorSignal<BitVector.N40> {
        public BitVector.N40 _getUninitialized() {
            return super._getUninitialized(40);
        }
    }

    public static class N41 extends BitVectorSignal<BitVector.N41> {
        public BitVector.N41 _getUninitialized() {
            return super._getUninitialized(41);
        }
    }

    public static class N42 extends BitVectorSignal<BitVector.N42> {
        public BitVector.N42 _getUninitialized() {
            return super._getUninitialized(42);
        }
    }

    public static class N43 extends BitVectorSignal<BitVector.N43> {
        public BitVector.N43 _getUninitialized() {
            return super._getUninitialized(43);
        }
    }

    public static class N44 extends BitVectorSignal<BitVector.N44> {
        public BitVector.N44 _getUninitialized() {
            return super._getUninitialized(44);
        }
    }

    public static class N45 extends BitVectorSignal<BitVector.N45> {
        public BitVector.N45 _getUninitialized() {
            return super._getUninitialized(45);
        }
    }

    public static class N46 extends BitVectorSignal<BitVector.N46> {
        public BitVector.N46 _getUninitialized() {
            return super._getUninitialized(46);
        }
    }

    public static class N47 extends BitVectorSignal<BitVector.N47> {
        public BitVector.N47 _getUninitialized() {
            return super._getUninitialized(47);
        }
    }

    public static class N48 extends BitVectorSignal<BitVector.N48> {
        public BitVector.N48 _getUninitialized() {
            return super._getUninitialized(48);
        }
    }

    public static class N49 extends BitVectorSignal<BitVector.N49> {
        public BitVector.N49 _getUninitialized() {
            return super._getUninitialized(49);
        }
    }

    public static class N50 extends BitVectorSignal<BitVector.N50> {
        public BitVector.N50 _getUninitialized() {
            return super._getUninitialized(50);
        }
    }

    public static class N51 extends BitVectorSignal<BitVector.N51> {
        public BitVector.N51 _getUninitialized() {
            return super._getUninitialized(51);
        }
    }

    public static class N52 extends BitVectorSignal<BitVector.N52> {
        public BitVector.N52 _getUninitialized() {
            return super._getUninitialized(52);
        }
    }

    public static class N53 extends BitVectorSignal<BitVector.N53> {
        public BitVector.N53 _getUninitialized() {
            return super._getUninitialized(53);
        }
    }

    public static class N54 extends BitVectorSignal<BitVector.N54> {
        public BitVector.N54 _getUninitialized() {
            return super._getUninitialized(54);
        }
    }

    public static class N55 extends BitVectorSignal<BitVector.N55> {
        public BitVector.N55 _getUninitialized() {
            return super._getUninitialized(55);
        }
    }

    public static class N56 extends BitVectorSignal<BitVector.N56> {
        public BitVector.N56 _getUninitialized() {
            return super._getUninitialized(56);
        }
    }

    public static class N57 extends BitVectorSignal<BitVector.N57> {
        public BitVector.N57 _getUninitialized() {
            return super._getUninitialized(57);
        }
    }

    public static class N58 extends BitVectorSignal<BitVector.N58> {
        public BitVector.N58 _getUninitialized() {
            return super._getUninitialized(58);
        }
    }

    public static class N59 extends BitVectorSignal<BitVector.N59> {
        public BitVector.N59 _getUninitialized() {
            return super._getUninitialized(59);
        }
    }

    public static class N60 extends BitVectorSignal<BitVector.N60> {
        public BitVector.N60 _getUninitialized() {
            return super._getUninitialized(60);
        }
    }

    public static class N61 extends BitVectorSignal<BitVector.N61> {
        public BitVector.N61 _getUninitialized() {
            return super._getUninitialized(61);
        }
    }

    public static class N62 extends BitVectorSignal<BitVector.N62> {
        public BitVector.N62 _getUninitialized() {
            return super._getUninitialized(62);
        }
    }

    public static class N63 extends BitVectorSignal<BitVector.N63> {
        public BitVector.N63 _getUninitialized() {
            return super._getUninitialized(63);
        }
    }

    public static class N64 extends BitVectorSignal<BitVector.N64> {
        public BitVector.N64 _getUninitialized() {
            return super._getUninitialized(64);
        }
    }
}
