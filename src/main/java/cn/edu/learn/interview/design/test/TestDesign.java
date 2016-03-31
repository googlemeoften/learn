package cn.edu.learn.interview.design.test;

import cn.edu.learn.interview.design.single.SingleTon;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class TestDesign {

    @Test
    public void testSingle() throws InterruptedException {
        final Set<SingleTon> sets = Collections.synchronizedSet(new HashSet<SingleTon>());
        final CountDownLatch latch = new CountDownLatch(100);

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sets.add(SingleTon.getInstance("dave" + Math.random() * 100));
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
        System.out.println(sets.size());
    }
}
