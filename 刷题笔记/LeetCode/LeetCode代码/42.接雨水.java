/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (47.56%)
 * Likes:    774
 * Dislikes: 0
 * Total Accepted:    46K
 * Total Submissions: 96.2K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 * '[10,0,0,10]'
 * [1,2,3,4,3,2,1]
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
/**
 * 双指针，从两端向中间，小的向中间移动：
 *      【左边】如果当前的高度小于另一端 high 指针指向的高度，被积的雨水量等于 Math.min(left, height[high]) - height[cur], 右边类似
 *      如果当前高度大于 high 所指向的高度，则从右边 开始向中间走
 */
// @lc code=start
class Solution {
    public int trap(int[] height) {
        int low = 0, high = height.length - 1;
        int left = 0, right = 0;       //left 记录左边上一次遇到的最大值， right 记录右边的上一次遇到的最大值
        int res = 0;
        while (low < high) {
            //左边小于右边，左边向中间走
            if (height[low] <= height[high]) {
                //更新左边的最大值
                if (height[low] >= left) {
                    left = height[low];
                } else {           //记录雨水量
                    res += Math.min(left, height[high]) - height[low];
                }
                low++;
            } else {       //右边小于左边，右边向中间走
                //更新右边的最大值
                if (height[high] >= right) {
                    right = height[high];
                } else {          //记录雨水量
                    res += Math.min(right, height[low]) - height[high];
                }
                high--;
            }
        }

        return res;
    }
}
// @lc code=end

