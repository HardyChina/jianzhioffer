package part4;

import common.TreeNode;
import common.Util;

import java.util.Arrays;

/**
 * @author lzh
 */
public class Test37 {

    int index= 0;
    String Serialize(TreeNode root) {
        String serialize = new String();
        if (root == null){
            serialize += "#,";
            return serialize;
        }
        serialize += root.val;
        serialize += ",";
        serialize += Serialize(root.left);
        serialize += Serialize(root.right);

        return serialize;
    }

    /**
     * 注意 index表示的是strr的下标，每一次递归strr向后 移动一位，虽然没有显式递归出口，实际上是有的if(strr[index].equals("#")) return index++ return null;
     * @param str
     * @return
     */

    TreeNode Deserialize(String str) {

        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index++]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }else {
            index++;
        }

        return node;

    }

    public static void main(String[] args) {
        TreeNode root = Util.getTestTree().get(0);
        Test37 test = new Test37();
        String str = test.Serialize(root);
        System.out.println(str);
        test.Deserialize(str);
    }
}
