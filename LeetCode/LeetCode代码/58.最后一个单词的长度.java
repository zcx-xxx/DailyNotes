/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        String[] strArr = s.split(" ");

        if(strArr.length > 0){
            return strArr[strArr.length - 1].length();
        } else {
            return 0;
        }
    }
}

