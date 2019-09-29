/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0, j = height.length - 1;

        while(i < j){
            if(Math.min(height[i], height[j]) * (j - i) > area){
                area = Math.min(height[i], height[j]) * (j - i);
            }

            if(height[i] < height[j]){
                ++i;
            } else {
                --j;
            }
        }
        return area;
    }
}

