import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    public List<List<Integer>> resList = new ArrayList<>();
    public List<Integer> curList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList
    }

    public int fun(TreeNode root, int curSum, int sum){
        if(root.left == null && root.right == null){
            if(curSum + root.val == sum){
                curList.add(root.val);
                resList.add(curList);
            }
        }
    }
}

