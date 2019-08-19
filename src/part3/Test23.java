package part3;

import common.ListNode;

/**
 * 链表中环的入口节点
 * @author lzh
 */
public class Test23 {
    /**
     * 类似于上一题，使用快慢指针,没有环则返回空.
     * 先判断是否有环，在找出环的长度，然后类似于第22题
     * @param pHead
     * @return
     */
    public static ListNode entryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        // 判断是否有环
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null){
            return null;
        }
        // 计算环长度
        ListNode next = meetingNode.next;
        // 注意不要设置为0
        int lenth = 1;
        while (next != meetingNode){
            next = next.next;
            lenth++;
        }
        ListNode behind = pHead;
        ListNode pre = pHead.next;
        for (int i = 0; i < lenth - 1; i++) {
            pre = pre.next;
        }
        while (behind != pre){
            behind = behind.next;
            pre = pre.next;
        }
        return behind;
    }

    /**
     * 使用快慢指针判断是否有环，并返回指针相遇的节点。
     * @param pHead
     * @return
     */
    static ListNode meetingNode(ListNode pHead){
        ListNode slow = pHead;
        ListNode fast = pHead.next;

        while (slow != null && fast != null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(entryNodeOfLoop(head).val);
    }

}
