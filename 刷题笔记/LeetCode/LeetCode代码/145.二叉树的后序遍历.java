import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (69.17%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    43K
 * Total Submissions: 62.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

import javax.swing.tree.TreeNode;


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
 * 第一解法，官方的题解
 *      通过 bfs + 栈，最后结果逆序输出，挺牛逼
 *      链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
 * 第二：设置一个标记位，标记当前节点的左右子树的访问情况
 * 第三：设置一个节点，标记上一次访问的节点，根据当前节点和上一次访问节点的关系分别进行相应的操作
 */
class Solution {
    private List<Integer> resList = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return resList;
        }    

        /**************** 官方题解 **************** */
        // Stack<TreeNode> stack = new Stack<>();
        // stack.add(root);
        
        // while(!stack.isEmpty()){
        //     TreeNode topNode = stack.peek();
        //     stack.pop();
        //     resList.add(topNode.val);
        //     // resList.add(0, topNode.val);
            
        //     if(topNode.left != null){
        //         stack.add(topNode.left);
        //     }
        //     if(topNode.right != null){
        //         stack.add(topNode.right);
        //     }
        // }
        
        // //反转 List
        // Collections.reverse(resList);
        /**************** 官方题解 **************** */
        
        /**************** 设置标记位 ************** */
        // Stack<MyTreeNode> stack = new Stack<>();
        // TreeNode tmp = root;
        
        // while(tmp != null || !stack.isEmpty()){
        //     while(tmp != null){
        //         MyTreeNode myTreeNode = new MyTreeNode();
        //         myTreeNode.node = tmp;
        //         myTreeNode.tag = 0;         //表示访问其左子树
        //         stack.add(myTreeNode);
        //         tmp = tmp.left;
        //     }
        //     //取栈顶元素
        //     MyTreeNode topNode = stack.peek();
            
        //     if(topNode.tag == 0){
        //         topNode.tag = 1;
        //         tmp = topNode.node.right;
        //     } else if(topNode.tag == 1){
        //         stack.pop();
        //         resList.add(topNode.node.val);
        //     }
        // }
        
        /**************** 设置标记位 ************** */

        /**************** 设置一个指向前一个节点的指针*************** */
        Stack<TreeNode> stack = new Stack();
        TreeNode tmp = root;
        TreeNode preNode = null;

        while(tmp != null || !stack.isEmpty()){
            while(tmp != null){
                stack.add(tmp);
                tmp = tmp.left;
            }

            TreeNode topNode = stack.peek();

            if(topNode.right == null || topNode.right == preNode){
                resList.add(topNode.val);
                preNode = topNode;
                stack.pop();
            } else {
                tmp = topNode.right;
            }
        }
        /**************** 设置一个指向前一个节点的指针*************** */
        return resList;
    }
    
    public class MyTreeNode{
        TreeNode node;      //节点
        int tag;           //标记位，0 表示访问了左子树，1表示访问了右子树
    }
}
// @lc code=end

