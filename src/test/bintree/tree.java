package test.bintree;

import common.TreeNode;
import common.Util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * // 用非递归的方法进行先序遍历
     * @param root
     */
    public static void preSearchNot(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                System.out.print(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop().right;
            }
        }

    }

    /**
     * 中序遍历非递归
     * @param root
     */
    public static void midSearchNot(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val);
                root = root.right;
            }
        }

    }

    /**
     * 双栈法，先按照头、右、左的顺序放入第一个栈，再将第一个栈的内容放到第二个栈，顺序就变为了左、右、头。
     * @param root
     */
    public static void afterSearchNot(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if (root.left !=null){
                s1.push(root.left);
            }
            if (root.right !=null){
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.print(s2.pop().val);
        }
    }

    /**
     * 单栈法，利用了peek方法，省去了一个栈
     * @param root
     */
    public static void afterSearchNot2(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode c = null;
        stack.push(root);
        while (!stack.isEmpty()){
            c = stack.peek();
            if (c.left!=null && root!=c.left && root!=c.right){
                stack.push(c.left);
            }
            // 打印了左节点，此时将有节点放入栈
            else if (c.right!=null && root!=c.right){
                stack.push(c.right);
            }else {
                System.out.print(stack.pop().val);
                root = c;
            }


        }

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
        System.out.println();
        System.out.println("非递归遍历");
        preSearchNot(root);
        System.out.println();
        midSearchNot(root);
        System.out.println();
        afterSearchNot(root);
        System.out.println();
        afterSearchNot2(root);
    }
}
