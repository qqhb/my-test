package com.mytest.local.data2;

/**
 * Created by hebo on 2016/4/28.
 */

//定义一个单链表
public class Node {

    //变量
    private int record;

    //下一个结点
    private Node nextNode;

    public Node(int record) {
        this.record = record;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
