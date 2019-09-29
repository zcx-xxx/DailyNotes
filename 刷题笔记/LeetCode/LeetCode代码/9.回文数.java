/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        } else if(x < 0){
            return false;
        }

        long res = 0;
        int tmp = x;
        while(tmp != 0){
            res = res * 10 + tmp%10;
            tmp /= 10;
        }

        if(res == x){
            return true;
        } else {
            return false;
        }
    }
}

