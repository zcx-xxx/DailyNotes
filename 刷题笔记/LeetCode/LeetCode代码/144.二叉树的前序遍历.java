import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (63.00%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    57.6K
 * Total Submissions: 91.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
 * 方法一：bfs + 栈
 * 方法二：直接将从左边走到底，同时访问根节点，然后依次出栈，如果有右子树，转向右子树。
 */
class Solution {
    private List<Integer> resList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return resList;
        }

        /************* bfs + 栈 ************** */
        // Stack<TreeNode> stack = new Stack<>();
        // stack.add(root);
        
        // while(!stack.isEmpty()){
        //     TreeNode topNode = stack.peek();
        //     stack.pop();
        //     resList.add(topNode.val);
            
        //     if(topNode.right != null){
        //         stack.add(topNode.right);
        //     }
        //     if(topNode.left != null){
        //         stack.add(topNode.left);
        //     }
        // }
        /************* bfs + 栈 ************** */
        
        /************* 迭代 ****************** */
        TreeNode tmp = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(tmp != null || !stack.isEmpty()){
            while(tmp != null){
                stack.add(tmp);
                resList.add(tmp.val);
                tmp = tmp.left;
            }
            
            TreeNode topNode = stack.peek();
            stack.pop();
            tmp = topNode.right;
        }
        /************* 迭代 ****************** */
        return resList;
    }
}
// @lc code=end

