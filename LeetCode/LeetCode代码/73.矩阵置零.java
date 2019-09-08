/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean flagRow = false, flagCol = false;

        for(int i = 0; i < n; ++i){
            if(matrix[i][0] == 0){
                flagCol = true;
            }
        }
        for(int i = 0; i < m; ++i){
            if(matrix[0][i] == 0){
                flagRow = true;
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; ++i){
            if(matrix[i][0] == 0){
                for(int j = 0; j < m; ++j){
                    matrix[i][j] = 0;
                }
            } else if(flagCol){
                matrix[i][0] = 0;
            }
        }
        for(int i = 1; i < m; ++i){
            if(matrix[0][i] == 0){
                for(int j = 0; j < n; ++j){
                    matrix[j][i] = 0;
                }
            } else if(flagRow){
                matrix[0][i] = 0;
            }
        }

        if(flagCol || flagRow){
            matrix[0][0] = 0;
        }
    }
}

