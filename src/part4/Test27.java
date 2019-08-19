package part4;

import common.TreeNode;

/**
 * 二叉树的镜像
 * @author lzh
 */
public class Test27 {
    /**
     * 二叉树镜像
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tem = root.left;
        root.left  = root.right;
        root.right = tem;

        Mirror(root.left);
        Mirror(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Mirror(root);
    }

}


