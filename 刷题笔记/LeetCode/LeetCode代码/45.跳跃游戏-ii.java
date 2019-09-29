/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */
class Solution {
    public int jump(int[] nums) {
        int start = 0;     //记录当前的起始位置
        int end = nums[0]; //记录一个寻找区间
        int maxPath = 0;   //记录当前最远可以到达的位置
        int cnt = 0;

        if(nums.length <= 1){
            return 0;
        }
        
        while(start <= end){
            cnt++;
            if(end >= nums.length - 1){
                return cnt;
            }

            for(int i = start; i <= end; ++i){
                if(i + nums[i] > maxPath){
                    maxPath = i + nums[i];
                }
            }

            start = end + 1;
            end = maxPath;
        }

        return cnt;
    }
}

