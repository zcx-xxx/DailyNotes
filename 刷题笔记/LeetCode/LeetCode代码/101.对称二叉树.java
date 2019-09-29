import java.util.LinkedList;
import java.util.Queue;


/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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

 /**
  * 递归
  */
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null){
//             return true;
//         } else {
//             return isSymmetric(root.left, root.right);
//         }
//     }

//     public boolean isSymmetric(TreeNode root1, TreeNode root2){
//         if(root1 == null && null == root2){
//             return true;
//         } else if(root1 == null || root2 == null){
//             return false;
//         } else {
//             return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
//         }
//     }
// }

 /**
  * 迭代
  */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        que.offer(root);

        while(!que.isEmpty()){
            TreeNode t1 = que.poll();
            TreeNode t2 = que.poll();

            if(t1 == null && null == t2){
                continue;
            }
            if(t1 == null || null == t2){
                return false;
            }
            if(t1.val != t2.val){
                return false;
            }
            que.offer(t1.left);
            que.offer(t2.right);
            que.offer(t2.left);
            que.offer(t1.right);
        }

        return true;
    }
}

