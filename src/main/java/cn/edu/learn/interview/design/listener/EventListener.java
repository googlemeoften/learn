package cn.edu.learn.interview.design.listener;

import cn.edu.learn.interview.design.listener.interfaces.Event;
import cn.edu.learn.interview.design.listener.interfaces.Listener;

/**
 * @description: 监听者
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class EventListener<T> implements Listener<T> {
    private Event<T> event;

    @Override
    public void update(Event<T> e) {
        this.event = e;
    }

    @Override
    public T getContent() {
        return event != null ? event.getContent() : null;
    }
}
