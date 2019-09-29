/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 5];
        dp[0] = 1; 
        dp[1] = 1;

        //特殊判断
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }

        int i = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int j = 1; j < s.length(); ++j){
            i = j + 1;
            dp[i] = 0;

            if(s.charAt(j - 1) != '0'){
                if(s.charAt(j) != '0'){
                    dp[i] += dp[i - 1];
                }

                tmp1 = s.charAt(j - 1) - '0';
                tmp2 = s.charAt(j) - '0';
                if((tmp1 == 1 || tmp1 == 2) && tmp1 * 10 + tmp2 <= 26 && tmp1 * 10 + tmp2 >= 10){
                    dp[i] += dp[i - 2];
                }
            } else if(s.charAt(j) != '0'){
                dp[i] += dp[i - 1];
            } else {
                return 0;
            }
        }

        return dp[s.length()];
    }
}

