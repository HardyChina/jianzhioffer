package part4;

import common.TreeNode;
import common.Util;

import java.util.*;

/**
 * 1.从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 2.把二叉树打印成多行
 * 3.之字形打印二叉树
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

    /**
     * 把二叉树打印为多行
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (pRoot == null){
            return lists;
        }
        int current = 1;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (treeNode.left!=null){
                queue.offer(treeNode.left);
                next++;
            }
            if (treeNode.right != null){
                queue.offer(treeNode.right);
                next++;
            }
            list.add(treeNode.val);
            current--;
            if (current == 0){
                lists.add(list);
                list = new ArrayList<>();
                current = next;
                next =0;
            }
        }

        return lists;
    }

    /**
     * 两个思路：1.通过两个栈实现，每一层的放入一个栈，一个栈为空（即打印完一层）后打印另个栈
     * 2.通过双向队列实现
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer> > PrintZ1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot==null){
            return lists;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int layer = 1;
        s1.push(pRoot);

        while (!s1.empty() || !s2.empty()){
            if (layer % 2 != 0){
                ArrayList<Integer> list = new ArrayList<>();
                while (! s1.empty()){
                    TreeNode treeNode = s1.pop();
                    if (treeNode!=null) {
                        s2.push(treeNode.left);
                        s2.push(treeNode.right);
                        list.add(treeNode.val);
                    }
                }
                // 一层循环完毕
                if (!list.isEmpty()){
                    lists.add(list);
                    layer++;
                }

            }else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!s2.empty()){
                    TreeNode treeNode = s2.pop();
                    if (treeNode!=null) {
                        s1.push(treeNode.right);
                        s1.push(treeNode.left);
                        list.add(treeNode.val);
                    }
                }
                if (!list.isEmpty()){
                    lists.add(list);
                    layer++;
                }

            }


        }

        return lists;

    }

    /**
     * 通过双向队列实现
     * @param
     * @return
     */
//    public static ArrayList<ArrayList<Integer> > PrintZ2(TreeNode pRoot) {
//
//
//    }


    public static void main(String[] args) {
        ArrayList<TreeNode> nodeArrayList = Util.getTestTree();
        printFromTopToBottom(nodeArrayList.get(0)).forEach(System.out::print);
        Print(nodeArrayList.get(0));
        PrintZ1(nodeArrayList.get(0));
        System.out.println();


    }
}
