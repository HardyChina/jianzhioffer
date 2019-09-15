package part4;

import common.TreeNode;

/**
 * 二叉搜索时转排序的双向链表
 * @author lzh
 */
public class Test36 {
    /**记录当前链表的最后一个节点*/
    private TreeNode leftLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            leftLast = pRootOfTree;
            return pRootOfTree;
        }
        // 首先将左子树转换成链表
        TreeNode left = Convert(pRootOfTree.left);
        // 将根节点插入的链表最后
        if (left != null){
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;
        // 将右子树转换为链表
        TreeNode right = Convert(pRootOfTree.right);
        // 根节点连接
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;

    }

    public static void main(String[] args) {

    }

}
