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

public class State<T> extends Signal<T> implements Update {
    public State(T initial) {
        super.set(initial);
    }

    /**
     * Set next value in deltaQ.
     * @param next next value.
     * @return current value.
     */
    public T set(T next) {
        DeltaQueue.add(this, next);
        return get();
    }

    /**
     * Set next value in TimedQ.
     * @param incr incr future time.
     * @param next next value.
     * @return current value.
     */
    public T set(int incr, T next) {
        TimedQueue.add(incr, this, next);
        return get();
    }

    public void update(Future f) {
        super.set(f.get());
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
}
