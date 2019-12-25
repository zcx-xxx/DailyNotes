import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (51.02%)
 * Likes:    196
 * Dislikes: 0
 * Total Accepted:    97.1K
 * Total Submissions: 190.3K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 */
/**
 * 两种想法：
 *  * 首先排序，然后扫一遍
 *  * 将元素存入 set 中，存的时候判断元素是否重复
 */
// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        /**************排序*************** */
        // Arrays.sort(nums);
        // for(int i = 1; i < nums.length; ++i){
        //     if(nums[i] == nums[i - 1]){
        //         return true;
        //     }
        // }
        // return false;
        /**************排序*************** */

        /****************集合************* */
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; ++i){
            boolean flag = set.add(nums[i]);
            if(!flag){
                return true;
            }
        }

        return false;
        /****************集合************* */
    }
}
// @lc code=end

