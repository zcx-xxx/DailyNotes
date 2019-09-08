import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
 * 方法一
 */
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }

//         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//     }
// }

/**
 * 方法二
 */
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int res = 0;

        if(root == null){
            return res;
        }

        queue.offer(new Pair<TreeNode, Integer>(root, 1));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> tPair = queue.peek();
            TreeNode tmp = null;
            int hei = 0;
            queue.poll();

            if(tPair != null){
                tmp = tPair.getKey();
                hei = tPair.getValue();
                if(hei > res){
                    res = hei;
                }
            }

            if(tmp.left != null){
                queue.offer(new Pair<TreeNode, Integer>(tmp.left, hei + 1));
            }
            if(tmp.right != null){
                queue.offer(new Pair<TreeNode, Integer>(tmp.right, hei + 1));
            }
        }

        return res;
    }
}
