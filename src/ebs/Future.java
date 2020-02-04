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

import static gblibx.Util.*;

/*package*/ class Future {
    /*package*/ Future(Update update, Object next) {
        __update = update;
        set(next);
    }

    /*package*/ <T> T get() {
        final T val = downcast(__next);
        invariant(isNonNull(val));
        set(null);
        return val;
    }

    /*package*/ void set(Object next) {
        __next = next;
    }

    /*package*/ boolean isSame(Update other) {
        return __update == other;
    }

    /*package*/ void update() {
        __update.update(this);
    }

    /*package*/ void fanout() {
        __update.fanout();
    }

    private Object __next;
    private final Update __update;
}
