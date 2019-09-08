import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int cur = 0;
        TreeSet

        while(cur <= high){
            if(nums[cur] == 0){
                int tmp = nums[cur];
                nums[cur] = nums[low];
                nums[low] = tmp;
                low++;
                cur++;
            }else if(nums[cur] == 2) {
                int tmp = nums[cur];
                nums[cur] = nums[high];
                nums[high] = tmp;
                high--;
            } else {
                cur++;
            }
        }

        return;
    }
}

