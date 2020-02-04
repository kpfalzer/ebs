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

import java.util.ArrayList;
import java.util.Map;

public class TimeWheel {
    public static TimeWheel theOne() {
        return __THE_ONE;
    }

    public static long run() {
        while (theOne().__updateTimed()) {
            theOne().__updateDelta();
        }
        return SimTime.now();
    }

    private boolean __updateTimed() {
        final TimedQueue q = TimedQueue.theOne();
        if (q.isEmpty()) return false;
        final Long now = q.firstKey();
        SimTime.theOne().advance(now);
        __fanout(__update(q.remove(now)));
        return true;
    }

    private boolean __updateDelta() {
        final ArrayList<Future> q = DeltaQueue.theOne();
        if (q.isEmpty()) return false;
        __fanout(__update(q));
        q.clear();
        return true;
    }

    private ArrayList<Future> __update(ArrayList<Future> futures) {
        for (Future f : futures) {
            f.update();
        }
        return futures;
    }

    private ArrayList<Future> __fanout(ArrayList<Future> futures) {
        for (Future f : futures) {
            f.fanout();
        }
        return futures;
    }

    private TimeWheel() {
    }

    private static final TimeWheel __THE_ONE = new TimeWheel();
}
