package part4;

import common.TreeNode;
import common.Util;

import java.util.*;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author 10592
 */
public class Test32 {

    /**
     * 通过队列作为容器，来实现层序遍历
     * 要点：queue的使用，队列中放的时Treenode而不是val否则无法完成左右子树的遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null ){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
           TreeNode treeNode = queue.poll();
           if (treeNode.left != null){
               queue.offer(treeNode.left);
           }
           if (treeNode.right != null){
               queue.offer(treeNode.right);
           }
           list.add(treeNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<TreeNode> nodeArrayList = Util.getTestTree();
        printFromTopToBottom(nodeArrayList.get(0)).forEach(System.out::print);

    }
}
