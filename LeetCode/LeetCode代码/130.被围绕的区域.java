import java.util.LinkedList;
import java.util.Queue;


/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */
class Solution {
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int height;
    private int width;
    private char[][] board;

    public class Node{
        public int x;
        public int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        this.width = board[0].length;
        this.height = board.length;
        this.board = board;
        
        bfs();

        return;
    }

    //广搜将与边相连的结点进行标记
    public void bfs(){
        Queue<Node> que = new LinkedList<>();

        //上
        for(int i = 0; i < width; ++i){
            if(board[0][i] == 'O'){
                que.offer(new Node(0, i));
            }
        }
        //左
        for(int i = 0; i < height; ++i){
            if(board[i][0] == 'O'){
                que.offer(new Node(i, 0));
            }
        }
        //下
        for(int i = 0; i < width; ++i){
            if(board[height - 1][i] == 'O'){
                que.offer(new Node(height - 1, i));
            }
        }
        //右
        for(int i = 0; i < height; ++i){
            if(board[i][width - 1] == 'O'){
                que.offer(new Node(i, width - 1));
            }
        }

        while(!que.isEmpty()){
            Node tmp = que.peek();
            que.poll();

            board[tmp.x][tmp.y] = 'S';
            for(int i = 0; i < dir.length; ++i){
                if(Judge(tmp.x + dir[i][0], tmp.y + dir[i][1])){
                    que.offer(new Node(tmp.x + dir[i][0], tmp.y + dir[i][1]));
                }
            }
        }

        for(int i = 0; i < height; ++i){
            for(int j = 0; j < width; ++j){
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    public boolean Judge(int x, int y){
        if(x < 0 || x >= height || y < 0 || y >= width || board[x][y] == 'X' || board[x][y] == 'S'){
            return false;
        }
        return true;
    }
}
// '[["X","O","X","X"],["O","X","O","X"],["X","O","X","O"],["O","X","O","X"],["X","O","X","O"],["O","X","O","X"]]'

class Solution {
    private int row;
    private int col;

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        row = board.length;
        col = board[0].length;
        int help = row * col;
        UnionSet unionSet = new UnionSet(help + 1);

        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                //如果是边界结点，则将其与 help 合并
                if(board[i][j] == 'O'){
                    if((i == 0 || j == 0 || i == row - 1 || j == col - 1)){
                        unionSet.Union(help, getId(i, j));
                    } else {
                        if(board[i - 1][j] == 'O'){
                            unionSet.Union(getId(i, j), getId(i - 1, j));
                        }
                        if(board[i + 1][j] == 'O'){
                            unionSet.Union(getId(i, j), getId(i + 1, j));
                        }
                        if(board[i][j - 1] == 'O'){
                            unionSet.Union(getId(i, j), getId(i, j - 1));
                        }
                        if(board[i][j + 1] == 'O'){
                            unionSet.Union(getId(i, j), getId(i, j + 1));
                        }
                    }
                }
            }
        }

        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(board[i][j] == 'O' && unionSet.findRoot(help) != unionSet.findRoot(getId(i, j))){
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }

    public int getId(int x, int y){
        return x * col + y;
    }

    /**
     * 并查集
     */
    public class UnionSet{
        public int[] parent;

        //构建一个大小为 num 的并查集
        public UnionSet(int num){
            parent = new int[num];

            for(int i = 0; i < parent.length; ++i){
                parent[i] = i;
            }
        }

        public int findRoot(int root){
            return (parent[root] == root) ? root : (parent[root] = findRoot(parent[root]));
        }

        public void Union(int x, int y){
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);

            if(xRoot != yRoot){
                parent[xRoot] = yRoot;
            }

            return;
        }
    }
}
