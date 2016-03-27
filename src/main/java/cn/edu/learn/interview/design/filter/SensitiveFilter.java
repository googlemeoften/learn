package cn.edu.learn.interview.design.filter;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class SensitiveFilter extends Filter {

    @Override
    void doRequest(Request request) {
        String str = request.requestStr;

        str = str.replaceAll("敏感", "**").replaceAll("色情", "**");

        request.requestStr = str;
    }

    @Override
    void doResponse(Response response) {
        response.responseStr += " 2--Sensitive ";
    }
}
