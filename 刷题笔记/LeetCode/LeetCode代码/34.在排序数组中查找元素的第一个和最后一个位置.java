/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (38.29%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    51.9K
 * Total Submissions: 135.1K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
/**
 * 可以做两次二分查找，第一次查询等于指定值的最大下标，第二次查询等于指定值的最小下标，边界出之类的需要稍加改动
 */
// @lc code=start
class Solution {
    private int[] nums;
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;

        return new int[]{getEqualsTargetMaxIndex(target), getEqualsTargetMinIndex(target)};
    }

    /**
     * 获得等于指定值的最大下标
     * @param target
     * @return
     */
    public int getEqualsTargetMaxIndex(int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //相等的时候判断当前的值是不是对应的最大下标，如果是，结束查询，否则 right = mid - 1
                //向左逼近
                if (mid - 1 >= 0 && nums[mid - 1] == target) {
                    right = mid - 1;
                } else {          //将最大下标赋值给 left
                    left = mid;
                    break;
                }
            }
        }

        //若 left 不越界，且 nums[left] == target, return left;
        if (left < nums.length && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    /**
     * 获得等于指定值的最小下标
     * @param target
     * @return
     */
    public int getEqualsTargetMinIndex(int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //相等的时候判断当前的值是不是对应的最大下标，如果是，结束查询，否则 left = mid + 1
                //向右逼近
                if (mid + 1 < nums.length &&  nums[mid + 1] == target) {
                    left = mid + 1;
                } else {         //同样将最大的下标赋值给 left
                    left = mid;
                    break;
                }
            }
        }

        //若 left 不越界，且 nums[left] == target, return left;
        if (left < nums.length && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
// @lc code=end

