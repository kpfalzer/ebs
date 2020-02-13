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

import static gblibx.Util.*;
import static java.util.Objects.isNull;

public class Signal<T> implements Source<T>, Update, Fanout {
    public T get() {
        return isNonNull(__source) ? __source.get() : _getUninitialized();
    }

    /**
     * Subclass should REALLY implement to prevent nulls in evaluations.
     * @return uninitialized value.
     */
    protected T _getUninitialized() {
        return null;
    }

    @Override
    public void addSensitivity(Process p) {
        if (isNull(__sensitivities)) {
            __sensitivities = new ArrayList<>();
        }
        __sensitivities.add(p);
    }

    /**
     * Set next value in deltaQ.
     *
     * @param next next value.
     * @return current value.
     */
    public T set(T next) {
        //no need to redux a null
        if (isNonNull(next) || isNonNull(get())) {
            DeltaQueue.add(this, next);
        }
        return get();
    }

    protected T _set(T val) {
        if (isNull(__source)) {
            __source = new Value<T>(val);
            return __source.get();
        } else {
            Value<T> src = downcast(__source);
            return src.set(val);
        }
    }

    @Override
    public void fanout() {
        acceptIfNotNull(__sensitivities, (processes) ->{
            for (Process p : processes) {
                p.process();
            }
        });
    }

    public void update(Future f) {
        _set(f.get());
        setFuture(null);
    }

    @Override
    public Future getFuture() {
        return __delta;
    }

    @Override
    public void setFuture(Future future) {
        __delta = future;
    }

    /**
     * Likely we'll be updating deltaQ more than realQ, so optimize by keeping reference
     * here, so don't have to search in deltaQ.
     */
    private Future __delta;

    public static class Value<T> implements Source<T> {
        public Value(T val) {
            __val = val;
        }

        public T set(T val) {
            __val = val;
            return __val;
        }

        private T __val;

        @Override
        public T get() {
            return __val;
        }
    }

    private Source<T> __source;
    //todo: needed? private ArrayList<Sink<T>> __fanouts;
    private ArrayList<Process> __sensitivities;
}
