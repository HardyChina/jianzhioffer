package part4;

import common.RandomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，
 * 以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，
 * 否则判题程序会直接返回空）
 * @author lzh
 */
public class Test35 {
    /**
     * 分三步走：1.在原有链表的基础上复制，不设置random 2.设置 3.拆分
     * @param pHead
     * @return
     */
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        cloneNodes(pHead);
        connect(pHead);
        return reConnect(pHead);

    }
    public static void cloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode cloneNode = new RandomListNode(pNode.label);
            cloneNode.next = pNode.next;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }

    }
    public static void connect(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode cloneNode;
        while (pNode != null){
            cloneNode = pNode.next;
            if (pNode.random != null){
                cloneNode.random = pNode.random.next;
            }
            pNode = cloneNode.next;
        }
    }
    public static RandomListNode reConnect(RandomListNode pHead){


        RandomListNode currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            // 给cloneNode赋值
            RandomListNode cloneNode = currentNode.next;
            // 分别给两个Node的next赋值
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            // current 往后走
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }



    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode l1 = new RandomListNode(2);
        RandomListNode l2 = new RandomListNode(3);
        RandomListNode l3 = new RandomListNode(4);
        RandomListNode l4 = new RandomListNode(5);
        head.next = l1;
        head.random = l2;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        RandomListNode cHead = Clone(head);
        System.out.println(cHead.label);
    }
}
