package org.mindidea.core00_basic;

import java.util.HashMap;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * 2020/11/14 23:31
 * https://mindidea.org
 */
public class Demo {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        double f = 1.12;
        Human h = new Student();
        h.setAge(10);
        System.out.println(h);
    }
}

class Student extends Human {

    public void test() {
        System.out.println("test in student");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
class Human {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void test() {
        System.out.println("test in human");
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}