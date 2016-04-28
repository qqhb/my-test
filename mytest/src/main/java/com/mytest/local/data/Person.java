package com.mytest.local.data;

/**
 * Created by hebo on 2016/4/28.
 */
public class Person {

    private String name;// 姓名

    private int age;// 年龄

    private int personNo;// 编号

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

    public int getPersonNo() {
        return personNo;
    }

    public void setPersonNo(int personNo) {
        this.personNo = personNo;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age +
                ", personNo=" + personNo
               ;
    }
}
