import java.util.ArrayList;
/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */
import java.util.List;
class Solution {
    private Vertex root = new Vertex();      //根节点
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private char[][] board = null;
    private List<String> list = null;

    /**定义字典树的结点结构 */
    private class Vertex {
        boolean isWord;        //标记是否是一个单词
        boolean isFlag;        //标记该单词是否被访问过
        String word;           //如果以该节点结尾的是一个单词则记录

        Vertex[] childs = new Vertex[26];

        public Vertex(){
            this.isWord = false;
            this.isFlag = false;
        }
    }

    /**字典树的操作 */
    /**添加单词，构造字典树 */
    public void addWord(String word){
        addWord(root, word, 0);
    }

    private void addWord(Vertex vertex, String word, int level){
        if(level == word.length()){
            vertex.isWord = true;
            vertex.word = word;
            return;
        } else {
            char c = word.charAt(level);
            int index = c - 'a';

            if(vertex.childs[index] == null){
                vertex.childs[index] = new Vertex();
            }

            addWord(vertex.childs[index], word, level + 1);
        }       
    }
  
    /**深搜 */
    private void dfs(int x, int y, Vertex currentNode){
        //判断指定坐标的点是否合法
        if(!judge(x, y)){
            return;
        }

        char c = board[x][y];
        int index = c - 'a';
        
        if(currentNode.childs[index] == null){
            return;
        } else if(currentNode.childs[index].isWord && !currentNode.childs[index].isFlag){
            currentNode.childs[index].isFlag = true;
            list.add(currentNode.childs[index].word);
        }
        board[x][y] = '@';

        for(int i = 0; i < dir.length; i++){
            dfs(x + dir[i][0], y + dir[i][1], currentNode.childs[index]);
        }

        board[x][y] = c;

        return;
    }

    /**判断当前元素是否合法 */
    private boolean judge(int x, int y) {
        if(x < 0 || x >= board.length || y < 0|| y >= board[0].length || board[x][y] == '@'){
            return false;
        }

        return true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.list = new ArrayList<>();
        
        //通过字符串数组构建
        for(int i = 0; i < words.length; i++){
            addWord(words[i]);
        }

        //遍历矩阵，然后进行深搜
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[i].length; ++j){
                dfs(i, j, root);
            }
        }

        return list;
    }
}


