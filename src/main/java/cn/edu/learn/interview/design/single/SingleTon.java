package cn.edu.learn.interview.design.single;

/**
 * @description: 单例模式
 * @USER:hey
 * @Date:2016/3/27
 */
public class SingleTon {
    private String name;

    private volatile static SingleTon singleTon;

    private SingleTon(String name) {
        this.name = name;
    }

    public static SingleTon getInstance(String name) {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null)
                    singleTon = new SingleTon(name);
            }
        }
        return singleTon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleTon singleTon = (SingleTon) o;

        return name.equals(singleTon.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
