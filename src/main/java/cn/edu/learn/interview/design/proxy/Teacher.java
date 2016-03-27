package cn.edu.learn.interview.design.proxy;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class Teacher implements Person {
    @Override
    public void sayHello(String name) {
        System.out.println(name + " say hello");
    }
}
