package part3;

/**
 * 在O（1）时间内完成链表的删除
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
            target.value = target.next.value;
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

}
class ListNode{
    int value;
    ListNode next;
}