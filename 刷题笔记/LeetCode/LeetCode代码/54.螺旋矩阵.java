import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        if(matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m, t = 0, b = n;       //设置边界

        while(true){
            //从左往右
            for(int i = l; i < r; ++i){
                list.add(matrix[t][i]);
                cnt++;
            }
            t++;
            if(cnt == m * n){
                break;
            }
            for(int i = t; i < b; ++i){
                list.add(matrix[i][r - 1]);
                cnt++;
            }
            r--;
            if(cnt == m * n){
                break;
            }
            for(int i = r - 1; i >= l; --i){
                list.add(matrix[b - 1][i]);
                cnt++;
            }
            b--;
            if(cnt == m * n){
                break;
            }
            for(int i = b - 1; i >= t; --i){
                list.add(matrix[i][l]);
                cnt++;
            }
            l++;
            if(cnt == m * n){
                break;
            }
        }

        return list;
    }
}

