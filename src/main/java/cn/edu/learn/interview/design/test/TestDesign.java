package cn.edu.learn.interview.design.test;

import cn.edu.learn.interview.design.single.SingleTon;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class TestDesign {

    @Test
    public void testSingle() throws InterruptedException {
        final Set<SingleTon> sets = new HashSet<SingleTon>();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sets.add(SingleTon.getInstance());
                }
            }).start();
        }

        Thread.sleep(1000);

        System.out.println(sets.size());
    }

    @Test
    public void testChain(){}

}
