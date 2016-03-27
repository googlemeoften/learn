package cn.edu.learn.interview.design.single;

/**
 * @description: 单例模式
 * @USER:hey
 * @Date:2016/3/27
 */
public class SingleTon {
    private static volatile SingleTon singleTon;

    private SingleTon() {}

    public static SingleTon getInstance() {
        if (singleTon == null)
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }

        return singleTon;
    }
}
