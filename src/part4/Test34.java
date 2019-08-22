package part4;

import common.TreeNode;
import common.Util;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * @author lzh
 */
public class Test34 {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return lists;
        }

        list.add(root.val);
        target -= root.val;
        // 如果是叶节点且符合要求
        if (target == 0 && root.right == null && root.left == null){
            lists.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() -1);
        return lists;
    }

    public static void main(String[] args) {
        Test34 test = new Test34();
        ArrayList<ArrayList<Integer>> l = test.FindPath(Util.getTestTree().get(0),3);
        System.out.println();
    }
}
