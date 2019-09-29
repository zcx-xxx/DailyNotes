import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    private int[] inorder;
    private int[] postorder;
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int tag;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.tag = postorder.length - 1;

        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }

        return generateTree(0, postorder.length - 1);
    }

    //通过中序遍历的 s 到 e 生成二叉树，并返回根节点
    public TreeNode generateTree(int s, int e){
        if(s > e){
            return null;
        }

        int index = map.get(postorder[tag]);
        //构造根节点
        TreeNode node = new TreeNode(postorder[tag--]);
        //生成右子树
        node.right = generateTree(index + 1, e);
        //生成左子树
        node.left = generateTree(s, index - 1);

        return node;
    }
}

