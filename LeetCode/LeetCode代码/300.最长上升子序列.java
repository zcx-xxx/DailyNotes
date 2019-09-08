/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */
class Solution {
    public int[] nums;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;

        if (nums.length <= 1){
            return nums.length;
        }

        int tag = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[tag]){
                nums[++tag] = nums[i];
            } else {
                int index = findPosition(nums[i], 0, tag);
                nums[index] = nums[i];
            }
        }

        return tag + 1;
    }

    //二分查找第一个大于等于指定元素的下标
    public int findPosition(int elem, int s, int e){

        while(s < e){
            int mid = (s + e) / 2;

            if(nums[mid] < elem){
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }
}

