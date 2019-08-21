package common;

import java.util.ArrayList;

public class Util {
    public static ArrayList<TreeNode> getTestTree(){
        ArrayList<TreeNode> treeNodeList = new ArrayList<>();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        treeNodeList.add(root1);

        return treeNodeList;
    }
}
