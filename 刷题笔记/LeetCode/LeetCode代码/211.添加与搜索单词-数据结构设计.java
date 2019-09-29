/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */
class WordDictionary {
    /**根节点 */
    private Vertex root = new Vertex();
    /**
     * 字典树的结点结构
     */
    private class Vertex{
        public boolean isWord;
        public Vertex[] childs = new Vertex[26];

        public Vertex(){
            isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(root, word, 0);
    }

    /**添加单词 */
    private void addWord(Vertex vertex, String word, int level){
        if(level == word.length()){
            vertex.isWord = true;
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    /**查询指定的单词是否存在 */
    private boolean search(Vertex vertex, String word, int level){
        //
        if(level == word.length()){
            return vertex.isWord;
        } else {
            char c = word.charAt(level);

            if(c == '.'){
                for(int i = 0; i < vertex.childs.length; ++i){
                    if (vertex.childs[i] != null){
                        if(search(vertex.childs[i], word, level + 1)){
                            return true;
                        }
                    }
                }

                return false;
            } else {
                int index = c - 'a';
                if(vertex.childs[index] == null){
                    return false;
                } else {
                    return search(vertex.childs[index], word, level + 1);
                }
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

