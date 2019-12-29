/*
 * @lc app=leetcode.cn id=980 lang=java
 *
 * [980] 不同路径 III
 *
 * https://leetcode-cn.com/problems/unique-paths-iii/description/
 *
 * algorithms
 * Hard (68.60%)
 * Likes:    30
 * Dislikes: 0
 * Total Accepted:    2.7K
 * Total Submissions: 4K
 * Testcase Example:  '[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]'
 *
 * 在二维网格 grid 上，有 4 种类型的方格：
 * 
 * 
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 
 * 
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 
 * 示例 2：
 * 
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径： 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 
 * 示例 3：
 * 
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length * grid[0].length <= 20
 * 
 * 
 */

// @lc code=start
class Solution {
    private int res = 0;     //记录最终的路径条数
    private int cnt = 0;     //记录可以走的格子的个数
    private int startPosX = -1, startPosY = -1;     //记录开始位置的坐标
    private int endPosX = -1, endPosY = -1;        //记录结束位置的坐标
    private int[][] map;
    private boolean flag = true;     //标记位，第一次进入时从开始位置开始

    public int uniquePathsIII(int[][] grid) {
        if(grid == null){
            return 0;
        }
        map = grid;

        init();
        dfs(startPosX, startPosY, 1);
        
        return res;
    }

    /**
     * 初始化
     */
    public void init(){
        for(int i = 0; i < map.length; ++i){
            for(int j = 0; j < map[0].length; ++j){
                if(map[i][j] == 1){         //起始位置记录
                    startPosX = i;
                    startPosY = j;
                } else if(map[i][j] == 2){      //终止位置
                    endPosX = i;
                    endPosY = j;
                } else if(map[i][j] == 0){       //空白位置
                    cnt++;
                }
            }
        }
    }

    /**
     * dfs
     * @param curx 当前坐标
     * @param cury
     * @param curCnt 当前访问的是第几个节点
     */
    public void dfs(int curx, int cury, int curCnt){
        //一开始节点为第一个节点，则最后一个节点为 curCnt + 2 个节点
        if(curx == endPosX && cury == endPosY && curCnt == cnt + 2){
            res++;
            return;
        }

        if(curx == startPosX && cury == startPosY){
            // return;
            if(!flag){
                return;
            }
            flag = false;
        } else if(curx == endPosX && cury == endPosY){
            return;
        }

        //依次访问各个方向
        for(int i = -1; i < 2; ++i){
            for(int j = -1; j < 2; ++j){
                //枚举上下左右
                if(i * j == 0 && !(i == 0 && j == 0)){
                    //判断是否满足条件
                    if(judge(curx + i, cury + j)){
                        int tag = map[curx + i][cury + j];
                        map[curx + i][cury + j] = -1;
                        dfs(curx + i, cury + j, curCnt + 1);
                        map[curx + i][cury + j] = tag;
                    }
                }
            }
        }
    }

    /**
     * 判断指定位置的元素是否合法
     * @param x
     * @param y
     * @return
     */
    public boolean judge(int x, int y){
        if(x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != -1){
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

