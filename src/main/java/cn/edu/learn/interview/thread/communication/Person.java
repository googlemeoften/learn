package cn.edu.learn.interview.thread.communication;

/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class Person {
    private String name;
    private int age;
    private static volatile Person person;

    private Person(String name, int age) {
    }

    /**
     * ��˫���жϵ�ԭ������Ϊ���������⣬��volatile��Ϊ�˽�ֹ�����򣬲����ڴ�����ʵ���ڴ�Ŀɼ���
     *
     * @param name
     * @param age
     * @return
     */
    public Person getPerson(String name, int age) {
        if (person == null)
            synchronized (Person.class) {
                if (person == null)
                    person = new Person(name, age);
            }
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
