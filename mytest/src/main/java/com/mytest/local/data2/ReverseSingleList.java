package com.mytest.local.data2;

/**
 * Created by hebo on 2016/4/28.
 */
public class ReverseSingleList {

    /**
     * 利用递归在反转当前节点之前先反转后续节点
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        if(null == head || null == head.getNextNode()){
            return head;
        }

        Node reverseHead = reverse(head.getNextNode());
        head.getNextNode().setNextNode(head);
        head.setNextNode(null);
        return reverseHead;
    }


    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     * @param head
     * @return
     */
    public static Node reverse2(Node head){
        if(null == head){
            return head;
        }

        Node pre = head;
        Node cur = head.getNextNode();
        Node next;
        while(null != cur){
            next = cur.getNextNode();
            cur.setNextNode(pre);
            pre = cur;
            cur =  next;
        }

        //将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
        head.setNextNode(null);
        head = pre;

        return head;
    }


    public static void main(String[] args) {
        Node head = new Node(0);
        Node tmp = null;
        Node cur = null;
        // 构造一个长度为10的链表，保存头节点对象head
        for (int i = 1; i < 3; i++) {
            tmp = new Node(i);
            if (1 == i) {
                head.setNextNode(tmp);
            } else {
                cur.setNextNode(tmp);
            }
            cur = tmp;
        }
        //打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getRecord() + " ");
            h = h.getNextNode();
        }
        //调用反转方法
        head = reverse2(head);
        System.out.println("\n**************************");
        //打印反转后的结果
        while (null != head) {
            System.out.print(head.getRecord() + " ");
            head = head.getNextNode();
        }
    }
}
