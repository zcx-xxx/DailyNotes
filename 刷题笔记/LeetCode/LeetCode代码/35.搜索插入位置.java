import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (44.70%)
 * Likes:    392
 * Dislikes: 0
 * Total Accepted:    102K
 * Total Submissions: 228K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */
/**
 * 方法一：线性查找
 */
// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        /********** 线性查找 ************ */
        // for(int i = 0; i < nums.length; ++i){
        //     if(nums[i] >= target){
        //         return i;
        //     }
        // }
        
        // return nums.length;
        /********** 线性查找 ************ */
        
        /********** 二分查找(瞎写版) ********** */
        //查找第一个大于目标值的元素下标
        // int start = 0;
        // int end = nums.length - 1;
        // int mid = -1;
        
        // while(start <= end){
        //     int mid = (start + end) >>> 1;

        //     if(nums[mid] < target){
        //         start = mid + 1;
        //     } else if(nums[mid] == target){
        //         return mid;
        //     } else {
        //         end = mid - 1;
        //     }
        // }

        // return end + 1;
        /********** 二分查找(瞎写版) ********** */

        /********** 二分查找(标准版) ********** */
        // int start = 0, end = nums.length - 1;
        // if(nums[end] < target){
        //     return end + 1;
        // }
        
        // while(start < end){
        //     int mid = (start + end) >>> 1;
            
        //     if(nums[mid] < target){
        //         start = mid + 1;
        //     } else {
        //         end = mid;
        //     }
        // }
        
        // return start;
        /********** 二分查找(标准版) ********** */

        /********** 调用库函数 ********** */
        int index = Arrays.binarySearch(nums, target);
        if(index >= 0){
            return index;
        } else {
            return -index - 1;
        }
        /********** 调用库函数 ********** */
    }
}
// @lc code=end

