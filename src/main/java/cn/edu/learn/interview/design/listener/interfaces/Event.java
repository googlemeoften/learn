package cn.edu.learn.interview.design.listener.interfaces;

/**
 * @description: 监听的事件
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public interface Event<T> {

    /**
     * 修改事件状态
     * @param content
     */
    void setChange(T content);

    /**
     * 获取状态信息
     */
    T getContent();

}
