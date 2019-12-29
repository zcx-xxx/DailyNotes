/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 *
 * https://leetcode-cn.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (68.57%)
 * Likes:    148
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 17.4K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 
 * 示例 :
 * 
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 
 * 注意：
 * 
 * 
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 
 * 
 */
/**
 * 思路：分组扫描
 * * 首先将所有元素进行异或操作，得到两个目标元素的异或结果 x
 * * 然后通过 x & (-x) 得到 x 的最后一位 1
 *      注意：x 为 1 的二进制位表示的是这两个元素相应的二进制位不同，必定是一个为 1 ，另一个为 0
 * * 根据这个不同的二进制位便可以进行分组异或
 */
// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length; ++i){
            x ^= nums[i];
        }

        //获得 x 的最后一位 1
        x = x & (-x);
        int a = 0, b = 0;

        for(int i = 0; i < nums.length; ++i){
            if((x & nums[i]) > 0){
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[]{a, b};
    }
}
// @lc code=end

