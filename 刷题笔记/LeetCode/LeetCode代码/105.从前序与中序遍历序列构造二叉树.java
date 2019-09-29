import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
// class Solution {
//     private int[] preorder;
//     private int[] inorder;
//     private int tag;

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         this.preorder = preorder;
//         this.inorder = inorder;
//         this.tag = 0;

//         return generateTree(0, preorder.length - 1);
//     }

//     //用中序的 s 到 e 生成二叉树，并返回根节点
//     public TreeNode generateTree(int s, int e){
//         if(s > e){
//             return null;
//         }

//         TreeNode node = null;
//         for(int i = s; i <= e; ++i){
//             if(inorder[i] == preorder[tag]){
//                 node = new TreeNode(preorder[tag++]);
//                 node.left = generateTree(s, i - 1);
//                 node.right = generateTree(i + 1, e);
//                 break;
//             }
//         }

//         return node;
//     }
// }

class Solution {
    private int[] preorder;
    private int[] inorder;
    private int tag;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.tag = 0;

        //将中序遍历存入哈希表
        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }

        return generateTree(0, preorder.length - 1);
    }

    //用中序的 s 到 e 生成二叉树，并返回根节点
    public TreeNode generateTree(int s, int e){
        if(s > e){
            return null;
        }

        int index = map.get(preorder[tag]);
        TreeNode node = new TreeNode(preorder[tag++]);
        node.left = generateTree(s, index - 1);
        node.right = generateTree(index + 1, e);

        return node;
    }
}

