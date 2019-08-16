package part3;

/**
 * 反转链表
 * @author lzh
 */
public class Test24 {
    /**
     *反转链表，需要同时取得三个节点，要注意的是节点初始化，以及注意反转后原来的head.next为null
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

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 得到尾节点
        ListNode reverseList = reverseList1(head.next);
        // 当前节点的后一个节点指向自己
        head.next.next = head;
        // 当前节点的next节点不再指向原来后边的节点，最后原来头节点的next为空
        head.next = null;
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
       // System.out.println(reverseList(head).val);
        System.out.println(reverseList1(head).val);
    }
}
