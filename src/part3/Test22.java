package part3;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author 李震寰
 */
public class Test22 {
    /**
     * 使用快慢指针的方法两个指针一个从头结点开始，一个从第k个开始，然后同时前几，前边的节点走到头的时候后边的节点就是倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode findKthToTail(ListNode head,int k) {
        if (head == null || k <= 0){
            return null;
        }
        ListNode behind = head;
        ListNode pre = head;
        for (int i = 0; i < k-1; i++) {
            if (pre.next == null){
                return null;
            }
            pre = pre.next;
        }
        while (pre.next != null){
            pre = pre.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(findKthToTail(head,1).val);
    }
}
