/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
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
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        } else {
            getTreeHeight(root);
            return flag;
        }
    }

    /**
     * 获得子树的高度
     * @param root
     * @return
     */
    public int getTreeHeight(TreeNode root){
        if(root == null){
            return 0;
        } else {
            int left = getTreeHeight(root.left);
            int right = getTreeHeight(root.right);

            //在获得高度的过程中判断是否满足平衡二叉树的定义
            if(Math.abs(left - right) > 1){
                flag = false;
            }

            //返回当前子树的高度
            return Math.max(left, right) + 1;
        }
    }
}
// @lc code=end

