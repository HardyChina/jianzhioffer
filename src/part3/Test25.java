package part3;

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
    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return  list1;
        }
        ListNode mergeHead = null;
        if (list1.val < list2.val){
            mergeHead = list1;
            merge(list1.next, list2);
        }
        else {
            mergeHead = list2;
            merge(list1, list2.next);
        }
        return mergeHead;
    }
}
