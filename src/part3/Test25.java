package part3;

import common.ListNode;

/**
 * 合并两个排序的链表
 * @author lzh
 */
public class Test25 {
    /**
     * 递归实现
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return  list1;
        }
        ListNode mergeHead = null;
        if (list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = merge(list1.next, list2);
        }
        else {
            mergeHead = list2;
            mergeHead.next = merge(list1, list2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        list1.next = l2;
        l2.next = l3;
        ListNode list2 = new ListNode(2);
        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        list2.next = l21;
        l21.next = l22;
        ListNode mergeList = merge(list1,list2);
        while (mergeList != null){
            System.out.println(mergeList.val);
            mergeList = mergeList.next;
        }

    }
}
