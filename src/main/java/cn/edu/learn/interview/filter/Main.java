package cn.edu.learn.interview.filter;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        FilterChain chain = new FilterChain();

        chain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());

        Request request = new Request();
        request.requestStr = "在主菜单File下面,有个敏感的 <Power Save Mode>，顾名思义是 色情模式";

        Response response = new Response();
        response.responseStr = "response";

        chain.doFilter(request, response);

        System.out.println("requestStr: " + request.requestStr);
        System.out.println("responseStr: " + response.responseStr);
    }
}