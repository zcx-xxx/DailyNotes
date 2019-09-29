/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */
class Solution {
    public int cnt = 0;   //记录岛屿的数量
    public int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  //方向数组
    public char[][] map = null;
    public int n = 0, m = 0;

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        map = grid;
        n = grid.length;
        m = grid[0].length;

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(map[i][j] == '1'){
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        return cnt;
    }

    public void dfs(int row, int col){
        if(judge(row, col)){
            map[row][col] = '0';
            for(int i = 0; i < 4; ++i){
                dfs(row + dir[i][0], col + dir[i][1]);
            }
        }
    }

    //判断是否满足条件
    public boolean judge(int row, int col){
        if(row < 0 || row >= n || col < 0 || col >= m || map[row][col] == '0'){
            return false;
        }

        return true;
    }
}

