package part2;

/**
 * 重建二叉树
 * @author 李震寰
 */
public class Test6 {

    /**
     *  定义二叉树
     */

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
          if(pre == null||in==null||pre.length!=in.length){
              return null;
          }
          return construct(pre,0,pre.length-1,in,0,in.length-1);

    }
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param pre 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param in  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static TreeNode construct(int[] pre,int ps,int pe,int[] in, int is,int ie){
          if (ps>pe){
              return null;
          }
          int val = pre[ps];
          int index = is;
          while (index<=ie && in[index] != val){
              index++;
          }
          if (index> ie){
              throw new RuntimeException("error input!");
          }
          TreeNode node = new TreeNode(val);
          //递归调用，参数是关键
        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
          node.left = construct(pre, ps+1,ps+index-is,in,is,index-1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
          node.right = construct(pre,ps+index-is+1,pe,in,index+1,ie);

          return node;
    }
    // 中序遍历二叉树
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }

    }
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    public static void main(String[] args) {
        test1();
    }
}
