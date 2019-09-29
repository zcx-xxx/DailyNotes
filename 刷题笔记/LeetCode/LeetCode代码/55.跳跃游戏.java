/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */
class Solution {
    public boolean canJump(int[] nums) {
        int dis = 0;
        for(int i = 0; i < nums.length - 1; ++i){
            if(i <= dis){
                if(dis < i + nums[i]){
                    dis = i + nums[i];
                }
            } else {
                return false;
            }
        }

        if(dis != Integer.MAX_VALUE && dis >= nums.length - 1){
            return true;
        } else {
            return false;
        }
    }
}

