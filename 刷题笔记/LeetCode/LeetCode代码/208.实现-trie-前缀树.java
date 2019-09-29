/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */
class Trie {
    private Vertex root;        //根节点

    /**
     * Trie 的结点结构
     */
    private class Vertex{
        boolean isWord;
        boolean isPrefix;

        Vertex[] vertexs = new Vertex[26];

        public Vertex(){
            isPrefix = false;
            isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Vertex();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word, 0);        
    }

    private void insert(Vertex vertex, String word, int level){
        if(word.length() == level){
            vertex.isPrefix = true;
            vertex.isWord = true;
        } else {
            vertex.isPrefix = true;
            char c = word.charAt(level);
            int index = c - 'a';

            if(vertex.vertexs[index] == null){
                vertex.vertexs[index] = new Vertex();
            }

            insert(vertex.vertexs[index], word, level + 1);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Vertex vertex, String word, int level){
        if(level == word.length()){
            return vertex.isWord;
        } else {
            char c = word.charAt(level);
            int index = c - 'a';

            if(vertex.vertexs[index] == null){
                return false;
            } else {
                return search(vertex.vertexs[index], word, level + 1);
            }
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Vertex vertex, String prefix, int level){
        if(level == prefix.length()){
            return vertex.isPrefix;
        } else {
            char c = prefix.charAt(level);
            int index = c - 'a';

            if(vertex.vertexs[index] == null){
                return false;
            } else {
                return startsWith(vertex.vertexs[index], prefix, level + 1);
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

