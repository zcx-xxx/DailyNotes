import java.util.*;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> resList = new LinkedList<>();

    /**
     * 从底部开始进行层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Node> que = new LinkedList<>();

        if(root == null){
            return resList;
        } else {
            que.add(new Node(root, 0));
        }

        while(!que.isEmpty()){
            Node tmp = que.peek();
            que.poll();
            TreeNode node = tmp.treeNode;

            //每次以头插的方式添加数组
            if(resList.size() <= tmp.level){
                ((LinkedList)resList).addFirst(new ArrayList<Integer>());
            }

            resList.get(0).add(node.val);

            if(tmp != null){
                if(node.left != null){
                    que.add(new Node(node.left, tmp.level + 1));
                }
                if(node.right != null){
                    que.add(new Node(node.right, tmp.level + 1));
                }
            }
        }

        return resList;
    }
}

class Node{
    public TreeNode treeNode;
    public int level;

    public Node(TreeNode treeNode, int level){
        this.treeNode = treeNode;
        this.level = level;
    }

    public Node(){

    }
}

