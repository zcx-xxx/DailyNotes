/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int take = 0, noTake = 0;
        int tmp = 0;

        for(int i = 0; i < nums.length; ++i){
            tmp = noTake + nums[i];
            noTake = Math.max(take, noTake);
            take = tmp;
        }

        return Math.max(take, noTake);
    }
}

