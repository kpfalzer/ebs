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

import static gblibx.Util.acceptIfNotNull;

public class TimeWheel {
    public static TimeWheel theOne() {
        return __THE_ONE;
    }

    public interface CallBack {
        public void endOfCycle(TimeWheel tw);
    }

    private boolean __stop = false;

    private void __stop() {
        __stop = true;
    }

    public static void stop() {
        theOne().__stop();
    }

    public static long run() {
        return run(null);
    }

    private long __run(CallBack cb) {
        while (__stop && __updateTimed()) {
            __updateDelta();
            acceptIfNotNull(cb, (x) -> {
                x.endOfCycle(this);
            });
        }
        return SimTime.now();
    }

    public static long run(CallBack cb) {
        return theOne().__run(cb);
    }

    public String getTime() {
        return SimTime.theOne().toString();
    }

    public long now() {
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

    private void __updateDelta() {
        //signal fanout can cause deltaQ to be updated, so loop until no more.
        while (!DeltaQueue.theOne().isEmpty()) {
            SimTime.theOne().incrDelta();
            final ArrayList<Future> q = DeltaQueue.theOne();
            __fanout(__update(q));
        }
    }

    private ArrayList<Future> __update(ArrayList<Future> futures) {
        for (Future f : futures) {
            f.update();
        }
        return futures;
    }

    private void __fanout(ArrayList<Future> futures) {
        //since we could grow while fanout
        int n = futures.size();
        while (0 < n--) {
            futures.remove(0).fanout();
        }
    }

    private TimeWheel() {
    }

    private static final TimeWheel __THE_ONE = new TimeWheel();
}
