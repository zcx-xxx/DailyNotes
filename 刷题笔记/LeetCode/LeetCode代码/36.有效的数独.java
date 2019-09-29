/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        //判断所有的行
        for(int i = 0; i < len; ++i){
            int[] jud = new int[10];

            for(int j = 0; j < len; ++j){
                if(board[i][j] == '.'){
                    continue;
                } else if(jud[board[i][j] - '0'] == 0){
                    jud[board[i][j] - '0']++;
                } else {
                    return false;
                }
            }
        }
        //判断所有的列
        for(int i = 0; i < len; ++i){
            int[] jud = new int[10];

            for(int j = 0; j < len; ++j){
                if(board[j][i] == '.'){
                    continue;
                } else if(jud[board[j][i] - '0'] == 0){
                    jud[board[j][i] - '0']++;
                } else {
                    return false;
                }
            }
        }
        //判断九宫
        for(int i = 0; i < len; i += 3){
            for(int j = 0; j < len; j += 3){
                int[] jud = new int[10];
                for(int x = i; x < i + 3; ++x){
                    for(int y = j; y < j + 3; ++y){
                        if(board[x][y] == '.'){
                            continue;
                        } else if(jud[board[x][y] - '0'] == 0){
                            jud[board[x][y] - '0']++;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

