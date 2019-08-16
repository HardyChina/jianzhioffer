package part3;

/**
 * 反转链表
 * @author lzh
 */
public class Test24 {
    /**
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode reverseList = head;
        ListNode node = head;
        ListNode pre = null;

        while (node != null){
            ListNode next = node.next;
            if (next == null){
                reverseList = node;
            }
            node.next = pre;
            pre = node;
            node = next;
        }
        return reverseList;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(reverseList(head).val);
    }
}
