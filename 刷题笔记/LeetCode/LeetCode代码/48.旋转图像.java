/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }

		//首先进行左下右上的翻转，然后上下反转
        //左下 - 右上
        int len = matrix.length;
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len - i; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - i - 1];
                matrix[len - j - 1][len - i - 1] = tmp;
            }
        }
        
        //上 - 下
        for(int i = 0, j = len - 1; i < j; ++i, --j){
            for(int k = 0; k < len; ++k){
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = tmp;
            }
        }
    }
}

