package part3;

import common.TreeNode;

/**
 * 树的子结构
 * @author lzh
 */
public class Test26 {
    /**
     * 递归遍历树
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = isSubtree(root1, root2);
            }
            if (!result){
                result = hasSubtree(root1.left, root2);
            }
            if (!result){
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * 递归判断是否为子树
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSubtree(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return isSubtree(root1.left, root2.left) &&
                isSubtree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        System.out.println(hasSubtree(root1,root2));
        System.out.println(hasSubtree(null, null));
    }

}
