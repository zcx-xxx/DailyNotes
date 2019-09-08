/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int cnt = 1;
        int row = 0, col = 0;
        
        while(true){
            //向右移动
            for(; col < n; ++col){
                if(arr[row][col] == 0){
                    arr[row][col] = cnt;
                    ++cnt;
                } else {
                    break;
                }
            }
            --col;
            ++row;

            //向下移动
            for(; row < n; ++row){
                if(arr[row][col] == 0){
                    arr[row][col] = cnt;
                    ++cnt;
                } else {
                    break;
                }
            }
            --row;
            --col;

            //向左移动
            for(; col >= 0; --col){
                if(arr[row][col] == 0){
                    arr[row][col] = cnt;
                    ++cnt;
                } else {
                    break;
                }
            }
            ++col;
            --row;

            //向上移动
            for(; row >= 0; --row){
                if(arr[row][col] == 0){
                    arr[row][col] = cnt;
                    ++cnt;
                } else {
                    break;
                }
            }
            ++row;
            ++col;

            if(cnt == n*n + 1){
                break;
            }
        }

        return arr;
    }
}

