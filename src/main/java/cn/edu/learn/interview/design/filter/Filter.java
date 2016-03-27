package cn.edu.learn.interview.design.filter;

/**
 * @description: 过路器
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public abstract class Filter {
    Filter next;

    void doFilter(Request request, Response response) {
        doRequest(request);
        if (next != null)
            next.doFilter(request, response);
        doResponse(response);
    }

    void doRequest(Request request) {
    }

    void doResponse(Response response) {
    }
}
