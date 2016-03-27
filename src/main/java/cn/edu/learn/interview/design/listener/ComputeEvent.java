package cn.edu.learn.interview.design.listener;

import cn.edu.learn.interview.design.listener.interfaces.Event;

/**
 * @description: 事件
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class ComputeEvent<T> implements Event<T> {
    private T conetnt;

    @Override
    public void setChange(T content) {
        this.conetnt = content;
    }

    @Override
    public T getContent() {
        return conetnt;
    }
}
