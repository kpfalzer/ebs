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

public class SimTime {
    /*package*/
    static SimTime theOne() {
        return __THE_ONE;
    }

    public static long now() {
        return theOne().getTime();
    }

    public static long delta() {
        return theOne().getDelta();
    }

    private SimTime(long start) {
        __time = start;
        __resetDelta();
    }

    private void __resetDelta() {
        __delta = 0;
    }

    /*package*/ long incrDelta() {
        ++__delta;
        return __delta;
    }

    private SimTime() {
        this(0);
    }

    /*package*/ long advance(long to) {
        __time = to;
        __resetDelta();
        return __time;
    }

    public String toString() {
        return getTime() + "." + getDelta();
    }

    public long getTime() {
        return __time;
    }

    public long getDelta() {
        return __delta;
    }

    private long __time, __delta;

    private static final SimTime __THE_ONE = new SimTime();
}
