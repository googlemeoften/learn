package cn.edu.learn.interview.thread.pool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class ArrayBlockingQueue<T> {
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private boolean isShutDown = false;

    private T[] array;
    private int DEFAULT_CAPACITY = 16;
    private int front;
    private int tail;

    public ArrayBlockingQueue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        front = tail = 0;
    }

    public void insert(T value) {
        if (isShutDown)
            return;
        lock.lock();
        try {
            while (isFull())
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            array[tail++ % array.length] = value;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T remove() {
        lock.lock();
        try {
            while (isEmpty())
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            T temp = array[front++ % array.length];
            notFull.signalAll();
            return temp;
        } finally {
            lock.unlock();
        }
    }

    public void setShutDown(boolean isShutDown) {
        this.isShutDown = isShutDown;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == front;

    }

    public boolean isEmpty() {
        return front == tail;
    }
}
