package part4;

import common.TreeNode;

/**
 * 对称的二叉树,
 * @author lzh
 */
public class Test28 {
    /**
     *
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);

    }

    /**
     * 前序遍历的反向遍历 = 镜像二叉树的前序遍历
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSymmetrical(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 ==null || root2 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return isSymmetrical(root1.left, root2.right)&&
                isSymmetrical(root1.right,root2.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        System.out.println(isSymmetrical(root));
    }
}
