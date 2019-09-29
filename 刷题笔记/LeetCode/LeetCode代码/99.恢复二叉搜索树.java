/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    private int flag = 1;      //标记第几次出现异常顺序, 0 表示结束
    private TreeNode prev = null; //记录前一节点
    private int prevVal = Integer.MIN_VALUE;  //记录前一节点的值
    private TreeNode change = null;    //记录第一个需要改变的结点的地址
    private TreeNode change2 = null;    //记录第一个需要改变的结点的地址

    public void recoverTree(TreeNode root) {
        orderTravel(root);

        int tmp = change.val;
        change.val = change2.val;
        change2.val = tmp;
        
        return;
    }

    public void orderTravel(TreeNode root){
        if(root == null){
            return;
        }

        orderTravel(root.left);
        if(flag == 0){
            return;
        }
        visit(root);
        orderTravel(root.right);
    }

    public void visit(TreeNode root){
        if(root.val < prevVal){
            if(flag == 1){
                change = prev;
                change2 = root;
                flag++;
            } else if(flag == 2){
                change2 = root;
                flag = 0;
            }
        }

        prev = root;
        prevVal = root.val;
    }
}

