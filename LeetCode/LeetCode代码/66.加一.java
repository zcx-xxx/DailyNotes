/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int tmp = 1;
        int k;

        for(int i = digits.length - 1; i >= 0; --i){
            k = (digits[i] + tmp) % 10;
            tmp = (digits[i] + tmp) / 10;
            digits[i] = k;
        }

        if(tmp == 0){
            return digits;
        } else {
            int[] nums = new int[digits.length + 1];
            nums[0] = 1;
            return nums;
        }
    }
}

