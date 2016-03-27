package cn.edu.learn.interview.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 测试并发添加下的自增问题，CAS的优势：
 * @USER:hey
 * @Date:2016/3/25
 */
public class NumInc {

    private static Unsafe unsafe;
    private final static long offset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal reference
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);

            offset = unsafe.objectFieldOffset
                    (NumInc.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int value;

    public NumInc() {

    }

    public NumInc(int value) {
        this.value = value;
    }

    public int getAndInc() {
        for (; ; ) {
            int current = this.value;
            int next = current + 1;
            if (compareAndSet(current, next)) {
                return current;
            }
        }
    }

    private boolean compareAndSet(int except, int update) {
        return unsafe.compareAndSwapInt(this, offset, except, update);
    }

    public int getValue() {
        return value;
    }
}
