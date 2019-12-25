import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (66.88%)
 * Likes:    288
 * Dislikes: 0
 * Total Accepted:    21K
 * Total Submissions: 31.3K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */

// @lc code=start
class Solution {
    private char[][] map;
    private int size;
    private List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        map = new char[n + 5][n + 5];
        size = n;

        initMap();
        putQueens(0);

        return list;
    }

    /**
     * 初始化地图
     */
    public void initMap(){
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                map[i][j] = '.';
            }
        }
    }

    /**
     * 放置皇后
     * @param row 表示放的是第几行,从 0 开始，到 (size - 1) 行结束
     */
    public void putQueens(int row){
        if(row == size){
            List<String> tmpList = new ArrayList<>();
            for(int i = 0; i < size; ++i){
                tmpList.add(new String(map[i], 0, size));
            }
            list.add(tmpList);
            return;
        }

        for(int i = 0; i < size; ++i){
            if(Judge(row, i)){
                map[row][i] = 'Q';
                putQueens(row + 1);
                map[row][i] = '.';
            }
        }

        return;
    }

    /**
     * 判断当前位置是否可以放皇后
     * @param row 行
     * @param col 列
     * @return 是否可以放皇后
     */
    public boolean Judge(int row, int col){
        //判断上方
        for(int i = row - 1; i >= 0; --i){
            if(map[i][col] == 'Q'){
                return false;
            }
        }
        //判断左上
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j){
            if(map[i][j] == 'Q'){
                return false;
            }
        }
        //判断右上
        for(int i = row - 1, j = col + 1; i >= 0 && j < size; --i, ++j){
            if(map[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

