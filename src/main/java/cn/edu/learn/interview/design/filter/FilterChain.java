package cn.edu.learn.interview.design.filter;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class FilterChain {

    //过滤器头指针
    private Filter front;
    //过滤器尾指针
    private Filter tail;

    FilterChain addFilter(Filter filter) {
        Filter last = tail;
        tail = filter;
        if (last == null)
            front = tail;
        else
            last.next = tail;
        return this;
    }

    void doFilter(Request request, Response response) {
        front.doFilter(request, response);
    }
}
