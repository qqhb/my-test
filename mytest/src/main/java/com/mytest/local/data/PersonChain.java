package com.mytest.local.data;

/**
 * Created by hebo on 2016/4/28.
 */
public class PersonChain {

    //头结点
    private PersonChainNode head;

    // 链表实体(节点数)
    private int size;

    // 链表被操作的次数
    private int modCount;

    public int getSize(){
        return this.size;
    }

    /**
     * 添加新结点
     * @param person
     * 添加到链表节点的对象 由于实现细节，作为唯一标识，同一个编号的Person只能添加一次
     */
    public void addNode(Person person){
        if(!contains(person.getPersonNo())){ //如果链表中没有则添加新的节点
            if(head != null){//如果有头节点，则添加新节点作为头节点
                head = new PersonChainNode(person,head);
                size++;
                modCount++;
            }else{// 如果没有头节点，则添加对象作为头节点
                head = new PersonChainNode(person,null);
                size++;
                modCount++;

            }

        }
    }


    /**
     * 删除指定结点
     * @param personNo
     */
    public void deleteNode(int personNo){

        // 如果当前链表节点数为零
        if(size == 0){
            return;
        }

        // 如果只有一个节点并且正是需要删除的对象
        if(size == 1){
            if(head.person.getPersonNo() == personNo){
                head = null;
                size = 0;
            }
            return;
        }

        // 如果不存在该对象编号
        if(!contains(personNo)){
            return;
        }

        //定义整型保存被删除的节点的索引
        //（删除和索引都是不存在的，这里只是一个说法）
        int index = 0;
        for (PersonChainNode p = head ; p != null ; p = p.nextNode ){
            if(!(p.person.getPersonNo() == personNo)){
                index++;
            }else{
                break;
            }
        }

        // 如果删除的是第一个节点（即头节点）
        if(index == 0){
            head = new PersonChainNode(head.nextNode.person, head.nextNode.nextNode);
            size--;
            modCount++;
            return;

        }

        // 如果删除的节点不是第一个节点
        // 循环遍历，找到被删除节点的前一个节点
        // 其索引下标用count保存

        int count = 0;
        for (PersonChainNode p = head; p != null; p = p.nextNode){
            if (count == index - 1){  // 如果找到了被删除节点的前一个节点
                if(index == size - 1){ // 如果被删除节点是最后一个节点
                    p.nextNode = null; // 将被删除节点的前一个节点的引用指向空引用
                }else{ // 如果被删除节点不是最后一个节点
                    p.nextNode = p.nextNode.nextNode;  // 将被删除节点前一个节点对其引用指向被删除节点的下一个节点
                }
                size--;
                modCount++;
            }
            count++;//没有找到，索引加一
        }
    }

    /**
     * 根据名字在链表中的数据
     * @param name
     * @return
     */
    public Person[] searchNodeByPersonName(String name) {
        return null;
    }


    public Person[] searchNodeByPersonAge(int age) {
        return null;
    }

    /**
     * 通过编号查找对象
     * @param personNo
     * @return
     */
    public Person searchNode(int personNo){

        Person p = null;
        for (PersonChainNode pcn = head; pcn != null; pcn = pcn.nextNode){
            if(pcn.person.getPersonNo() == personNo){
                p = pcn.person;
            }
        }
        return p;
    }



    /**
     * 判断指定对象是否存在链表中
     * @param personNo
     * @return
     */
    private boolean contains(int personNo){
        if(size != 0){
            for (PersonChainNode pcn = head; pcn != null; pcn = pcn.nextNode){
                if(pcn.person.getPersonNo() == personNo){
                    return true;
                }
            }
        }
        return false;
    }




}
