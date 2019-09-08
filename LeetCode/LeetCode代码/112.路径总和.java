/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        justIsExists(root, 0, sum);
        
        return flag;    
    }

    /**
     * 判断是否存在路径总和为 sum
     * @param root
     * @param cnt
     * @param sum
     */
    public void justIsExists(TreeNode root, int cnt, int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(cnt + root.val == sum){
                flag = true;
            }
            return;
        }

        cnt += root.val;
        justIsExists(root.left, cnt, sum);
        justIsExists(root.right, cnt, sum);

        return;
    }
}

