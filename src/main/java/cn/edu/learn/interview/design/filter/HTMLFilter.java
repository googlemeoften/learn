package cn.edu.learn.interview.design.filter;

/**
 * @description:
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class HTMLFilter extends Filter {

    @Override
    void doRequest(Request request) {
        String str = request.requestStr;

        str = str.replaceAll("<", "[").replaceAll(">", "]");

        request.requestStr = str;
    }

    @Override
    void doResponse(Response response) {
        response.responseStr += " 1--HTML ";
    }
}
