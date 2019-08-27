package test.bintree;

import common.TreeNode;
import common.Util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的递归以及非递归遍历
 * @author lzh
 */
public class tree {
    public static void preSearch(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val);
        preSearch(root.left);
        preSearch(root.right);

    }
    public static void  midSearch(TreeNode root){
        if (root == null){
            return;
        }
        preSearch(root.left);
        System.out.print(root.val);
        preSearch(root.right);
    }
    public static void lastSearch(TreeNode root){
        if (root == null){
            return;
        }
        preSearch(root.left);
        preSearch(root.right);
        System.out.print(root.val);
    }
    // 非递归
    /**
     * 二叉树的层序遍历，通过一个队列实现，取出一个节点时将它的子节点加入队列。
     * @param root
     */
    public static void floorSearch(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val);
           if (node.left != null){
               queue.offer(node.left);
           }
           if (node.right != null){
               queue.offer(node.right);
           }
        }

    }
    public static void preSearchNot(TreeNode root){

    }

    public static void main(String[] args) {
        TreeNode root = Util.getTestTree().get(0);
        preSearch(root);
        System.out.println();
        midSearch(root);
        System.out.println();
        lastSearch(root);
        System.out.println();
        floorSearch(root);
    }
}
