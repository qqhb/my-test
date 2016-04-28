package com.mytest.local.data;

/**
 * Created by hebo on 2016/4/28.
 */
public class PersonChainNode {

    Person person;// 对象人

    PersonChainNode nextNode; // 该对象（'人'）保存的下一个对象的引用

    //构造
    public PersonChainNode(Person person, PersonChainNode nextNode) {
        this.person = person;
        this.nextNode = nextNode;
    }

    public PersonChainNode(Person person) {
        this.person = person;
    }

    //获取当前人
    public Person getPerson() {
       return this.person;
    }

    public PersonChainNode getNextEntity(){
        return this.nextNode;
    }

}
