package part3;

/**
 * 链表的删除
 * @author 10592
 */
public class Test18 {
    /**
     * 删除节点，通过后边节点代替当前节点在删除后节点完成删除。
     * @param head 头结点
     * @param target 目标节点
     */
    public void deleteNode(ListNode head, ListNode target){
        // 当target不为尾节点时
        if (target.next != null){
            target.val = target.next.val;
            target.next = target.next.next;
            target.next.next = null;
            System.gc();
        }
        // 当只有一个节点时
        else if (head == target){
            head = null;
        }
        // target为尾节点时
        else {
            ListNode indexNode = head;
            while (indexNode.next != target){
                indexNode.next = indexNode.next.next;
            }
            indexNode.next = null;
            System.gc();
        }

    }

    /**
     * 删除重复的节点
     * @param head 头结点
     * @return
     */
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null){
            throw new IllegalArgumentException("头结点不能为空");
        }
        ListNode preNode = null;
        ListNode node = head;
        while (node != null) {
            boolean needDel = false;
            ListNode next = node.next;
            // 当存在重复时删除，使preNode指向后边不重复的元素
            if (next != null && node.val == next.val) {
                needDel = true;
            }
            if (!needDel) {
                preNode = node;
                node = next;
            } else {
                int value = node.val;
                while (next!=null && next.val == value) {
                   next = next.next;
                }
                if (preNode == null){
                    head = next;
                }
                else {
                    preNode.next = next;
                }
                node = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next  = new ListNode(1);
        head.next = next;
        System.out.println(deleteDuplication(head));
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}