import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.67%)
 * Likes:    416
 * Dislikes: 0
 * Total Accepted:    50.5K
 * Total Submissions: 66.7K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

 /**
  * 可以使用位运算生成子集
  * 注意该处不包含重复元素
  * 
  * 应该可以使用组合的方法实现
  */
// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int end = (1 << len);
        List<List<Integer>> resList = new ArrayList<>();

        //直接枚举所有的情况
        for(int i = 0; i < end; ++i){
            List<Integer> tmp = new ArrayList<>();
            //判断每一个元素是否取
            for(int j = 0; j < len; ++j){
                if((i & (1 << j)) != 0){
                    tmp.add(nums[j]);
                }
            }
            resList.add(tmp);
        }

        return resList;
    }
}
// @lc code=end

