import java.util.*;
/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        fun(root, 0);

        return resList;
    }

    /**
     * 递归添加每一层
     */
    public void fun(TreeNode root, int level){
        if(root == null){
            return;
        }

        //判断第 level 层是否创建 List
        if(resList.size() <= level){
            resList.add(new LinkedList<Integer>());
        }
        
        LinkedList<Integer> list = (LinkedList) resList.get(level);
        if(level % 2 == 1){
            list.addFirst(root.val);
        } else {
            list.addLast(root.val);
        }
        
        fun(root.left, level + 1);
        fun(root.right, level + 1);

        return;
    }
}
