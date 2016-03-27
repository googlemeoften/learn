package cn.edu.learn.interview.design.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class JDKProxy implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before.....");
        method.invoke(target, args);
        System.out.println("after.....");
        return null;
    }

    public <T extends Person> T proxy(T obj){
        target = obj;
        Class clazz = target.getClass();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Test
    public void testProxy(){
        JDKProxy proxy = new JDKProxy();
        Person p = proxy.proxy(new Teacher());
        p.sayHello("dave");
    }
}
