package part4;

import common.TreeNode;

/**
 * 二叉搜索时转排序的双向链表
 * @author zlh
 */
public class Test36 {
    private TreeNode leftLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            leftLast = pRootOfTree;
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);

        if (left != null){
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;

    }

    public static void main(String[] args) {

    }

}
