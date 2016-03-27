package cn.edu.learn.interview.thread.test;


import cn.edu.learn.interview.thread.*;
import cn.edu.learn.interview.thread.communication.Person;
import cn.edu.learn.interview.thread.communication.Print;
import cn.edu.learn.interview.thread.communication.Print2;
import cn.edu.learn.interview.thread.communication.Print3;
import cn.edu.learn.interview.thread.pool.ArrayBlockingQueue;
import cn.edu.learn.interview.thread.pool.ExecutorService;
import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @description: test
 * @USER:hey
 * @Date:2016/3/25
 */
public class TestThread {

    private NumInc numInc;

    @Before
    public void init() {
        numInc = new NumInc();
    }

    /**
     * test cas：通过CAS操作修改值
     *
     * @throws InterruptedException
     */
    @Test
    public void testNumInc() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    numInc.getAndInc();
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println(numInc.getValue());
    }

    /**
     * test unsafe:使用Unsafe类，即使对象是单例也能够被生成
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testUnsafe() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        Person p = (Person) unsafe.allocateInstance(Person.class);
        p.setName("dave");
        p.setAge(10);
        System.out.println(p);
    }

    /**
     * synchronized 实现线程之间的同信
     */
    @Test
    public void testCommunication1() {
        final Print print = new Print();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    print.subPrint();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            print.mainPrint();
        }
    }

    /**
     * lock实现线程间的通信
     */
    @Test
    public void testCommunication2() {
        final Print2 print = new Print2();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    print.subPrint();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            print.mainPrint();
        }
    }

    /**
     * lock实现三个线程间的同信
     */
    @Test
    public void testCommunication3() {
        final Print3 print = new Print3();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    print.subPrint();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    print.sub2Print();
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            print.mainPrint();
        }
    }

    @Test
    public void testArrayBlockingQueue() {
        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    queue.insert(1);
                }
            }).start();
        }

        int sum = 0;
        while (true) {
            sum = sum + queue.remove();
            System.out.println(sum);
        }

    }

    @Test
    public void testInsert() {
        ArrayBlockingQueue queue = new ArrayBlockingQueue();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            queue.insert(i);
        }
    }

    @Test
    public void testRemove() {
        ArrayBlockingQueue queue = new ArrayBlockingQueue();
        queue.insert(1);
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " " + queue.remove());

        }
    }

    @Test
    public void testINC() {
        int[] i = new int[10];
        int j = 4;
        i[j++ % 10] = 5;
        System.out.println(Arrays.toString(i));
    }

    @Test
    public void testThreadPool() {
        ExecutorService service = new ExecutorService(3);
        final int k = 1;
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task finish");
                }
            });
        }
    }
}
