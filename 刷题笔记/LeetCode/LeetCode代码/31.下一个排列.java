/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (32.30%)
 * Likes:    335
 * Dislikes: 0
 * Total Accepted:    34.3K
 * Total Submissions: 106.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = false;

        //首先判断是否有下一个排列
        for(int i = nums.length - 1; i > 0; --i){
            if(nums[i] > nums[i - 1]){
                flag = true;
            }
        }

        //如果有下一个排列，找出来
        int index = -1;
        if(flag){
            //从右向左，找出第一个 p[i - 1] < p[i]
            for(int i = nums.length - 1; i > 0; --i){
                if(nums[i - 1] < nums[i]){
                    index = i - 1;
                    break;
                }
            }

            //从右向左，找出第一个大于 p[index] 的，并交换
            for(int i = nums.length - 1; i > index; --i){
                if(nums[i] > nums[index]){
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    break;
                }
            }

            //将 index 后的数据进行反转
            //与直接反转的代码合并
        }

        //反转
        for(int i = index + 1, j = nums.length - 1; i < j; ++i, --j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
          
    }
}
// @lc code=end

