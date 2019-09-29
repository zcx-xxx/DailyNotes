import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public ArrayList<TreeNode> generate_trees(int start, int end) {
        ArrayList<TreeNode> all_trees = new ArrayList<TreeNode>();
        if (start > end) {
          all_trees.add(null);
          return all_trees;
        }
    
        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            ArrayList<TreeNode> left_trees = generate_trees(start, i - 1);
    
            // all possible right subtrees if i is choosen to be a root
            ArrayList<TreeNode> right_trees = generate_trees(i + 1, end);
      
            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
  
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
          return new ArrayList<TreeNode>();
        }
        return generate_trees(1, n);
    }
}

