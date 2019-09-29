/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        return divideDeal(strs, 0, strs.length - 1);
    }

    public String divideDeal(String[] strs, int front, int low){
        if(front == low){
            return strs[low];
        }

        return commoString(divideDeal(strs, front, (front + low) / 2), divideDeal(strs, (front + low) / 2 + 1, low));
    }

    public String commoString(String str1, String str2){
        StringBuilder str = new StringBuilder();

        int i = 0;

        while(i < str1.length() && i < str2.length()){
            if(str1.charAt(i) == str2.charAt(i)){
                str.append(str1.charAt(i));
            } else {
                break;
            }
            i++;
        }

        return str.toString();
    }
}

