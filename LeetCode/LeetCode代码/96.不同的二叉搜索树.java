/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */
class Solution {
    public int numTrees(int n) {

        long cur = 1;
        for(int i = 0; i < n; ++i){
            cur = cur * (4 * i - 2) / (i + 1);
        }

        return (int)cur;
    }
}

