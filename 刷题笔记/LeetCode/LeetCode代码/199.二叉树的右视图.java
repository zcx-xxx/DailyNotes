import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        fun(root, 0);

        return list;
    }

    /**
     * 递归遍历，顺序：根 ---> 右子树 ---> 左子树
     * @param root
     * @param level
     */
    public void fun(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(list.size() <= level){
            list.add(root.val);
        }
        fun(root.right, level + 1);
        fun(root.left, level + 1);

        return;
    }
}

