/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 *
 * https://leetcode-cn.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (78.10%)
 * Likes:    96
 * Dislikes: 0
 * Total Accepted:    9.1K
 * Total Submissions: 11.7K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 
 * 
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 
 * 
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 
 * 
 * 
 * 示例 ：
 * 
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠      \
 * ⁠       1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定的数组的大小在 [1, 1000] 之间。
 * 
 * 
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
/**
 * 递归
 */
class Solution {
    private int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return constructMaximumBinaryTree(0, nums.length - 1);
    }

    //从 start 到 end 构建最大二叉树
    public TreeNode constructMaximumBinaryTree(int start, int end){
        if(start > end){
            return null;
        }
        int index = getMaximumElementIndex(start, end);
        //建树
        TreeNode root = new TreeNode(nums[index]);
        // root.val = nums[index];
        root.left = constructMaximumBinaryTree(start, index - 1);
        root.right = constructMaximumBinaryTree(index + 1, end);

        return root;
    }

    //获得从 start 到 end 最大元素的索引
    public int getMaximumElementIndex(int start, int end){
        int tag = -1;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if(nums[i] > tag){
                tag = nums[i];
                index = i;
            }
        }
        return index;
    }
}
// @lc code=end

