/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        long res = 0;
        int flag = 0;

        for(int i = 0; i < str.length(); ++i){
            if(0 == flag){
                if(str.charAt(i) == '+'){
                    flag = 1;
                } else if(str.charAt(i) == '-'){
                    flag = -1;
                } else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    flag = 1;
                    res = res * 10 + (str.charAt(i) - '0');
                } else if(str.charAt(i) != ' '){
                    break;
                }
            } else {
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    res = res * 10 + (str.charAt(i) - '0');
                    if(res*flag > ((1 << 31)-1)){
                        return (1 << 31)-1;
                    } else if( res*flag < -(1 << 31)) {
                        return -(1 << 31);
                    }
                } else {
                    break;
                }
            }
        }

        res = res * flag;

        if(res > ((1 << 31)-1)){
            return (1 << 31)-1;
        } else if( res < -(1 << 31)) {
            return -(1 << 31);
        } else {
            return (int)res;
        }
    }
}

