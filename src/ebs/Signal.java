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

import static gblibx.Util.downcast;
import static java.util.Objects.isNull;

public class Signal<T> implements Source<T>, Fanout {
    public T get() {
        return __source.get();
    }

    @Override
    public void addSensitivity(Process p) {
        if (isNull(__sensitivities)) {
            __sensitivities = new ArrayList<>();
        }
        __sensitivities.add(p);
    }

    public T set(T val) {
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
        for (Process p : __sensitivities) {
            p.process();
        }
    }

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
