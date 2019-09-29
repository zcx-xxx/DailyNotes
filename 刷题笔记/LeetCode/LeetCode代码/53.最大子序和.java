/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int max = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(nums[i - 1] > 0){
                nums[i] += nums[i - 1];
            }
            if(nums[i] > max){
                max = nums[i];
            }
        }

        return max;
    }
}

