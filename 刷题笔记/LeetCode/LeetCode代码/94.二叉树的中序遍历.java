import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
 * 方法一：递归
 */
// class Solution {
//     private List<Integer> list = new ArrayList<>();

//     public List<Integer> inorderTraversal(TreeNode root) {
//         inorderTra(root);
//         return list;
//     }

//     public void inorderTra(TreeNode root){
//         if(root == null){
//             return;
//         }

//         inorderTra(root.left);
//         list.add(root.val);
//         inorderTra(root.right);

//         return;
//     }
// }

/**
 * 方法二：迭代
 */
// class Solution {
    
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         Stack<TreeNode> tmp = new Stack<>();
//         TreeNode cur = root;

//         while(cur != null || !tmp.isEmpty()){
//             while(cur != null){
//                 tmp.push(cur);
//                 cur = cur.left;
//             }

//             cur = tmp.pop();
//             list.add(cur.val);
//             cur = cur.right;
//         }
//         return list;
//     }
// }

/**
 * 方法三：线索二叉树
 */
class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode tmp = null;

        while(cur != null){
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else{
                tmp = cur.left;

                while(tmp.right != null){
                    tmp = tmp.right;
                }

                tmp.right = cur;
                cur = cur.left;
                tmp.right.left = null;
            }
        }
        return list;
    }
}

