import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (58.41%)
 * Likes:    279
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 26.9K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */
/**
 * 使用三个二位数组记录，每一行，列，和九宫中元素的使用情况，然后直接回溯
 */
// @lc code=start
class Solution {
    private char[][] board;
    private boolean[][] rowNote = new boolean[9][9];        //记录每一行的使用情况
    private boolean[][] colNote = new boolean[9][9];        //记录每一列的使用情况
    private boolean[][] gridNote = new boolean[9][9];       //记录每一个九宫的使用情况
    private List<Point> points = new ArrayList<>();

    /**
     * 点类
     */
    public class Point{
        int row, col, val, grids;
        public Point(int row, int col, int grids){
            this.row = row;
            this.col = col;
            this.grids = grids;
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        init();    
        dfs(0);
    }

    //初始化
    public void init(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    int elem = board[i][j] - '1';
                    
                    int row = i;
                    int col = j;
                    int grids = (i / 3) * 3 + (j / 3);        //相当于将每一个九宫格进行编号，从上到下，从左到右为 0 - 8，使用三进制转换
                    
                    rowNote[row][elem] = true;
                    colNote[col][elem] = true;
                    gridNote[grids][elem] = true;
                } else {
                    points.add(new Point(i, j, (i / 3) * 3 + (j / 3)));
                }
            }
        }
    }

    //dfs 深搜
    public boolean dfs(int deep){
        if(deep == points.size()){
            for (Point point : points) {
                board[point.row][point.col] = (char)('1' + point.val);
            }
            return true;
        }

        for (int i = 0; i < 9; i++) {
            int row = points.get(deep).row;
            int col = points.get(deep).col;
            int grids = points.get(deep).grids;

            if(!(rowNote[row][i] || colNote[col][i] || gridNote[grids][i])){
                rowNote[row][i] = true;
                colNote[col][i] = true;
                gridNote[grids][i] = true;
                points.get(deep).val = i;
                
                //深搜
                if(dfs(deep + 1)){
                    return true;
                }
                
                //回溯
                rowNote[row][i] = false;
                colNote[col][i] = false;
                gridNote[grids][i] = false;
            }
        }
        return false;
    }
}
// @lc code=end

