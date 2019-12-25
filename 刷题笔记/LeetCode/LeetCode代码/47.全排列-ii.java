import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.97%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    31.7K
 * Total Submissions: 56.5K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    private int end;
    private int[] nums;
    private List<List<Integer>> resList = new ArrayList<>();
    /**
     * 全排列，可能包含有重复的元素
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        end = nums.length;
        this.nums = nums;
        Arrays.sort(nums, 0, end);

        generatePermuteUnique(0);

        return resList;
    }

    /**
     * 生成有重复数字的全排列
     * @param index
     */
    public void generatePermuteUnique(int index){
        //递归结束
        if(index == end){
            List<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < end; ++i){
                tmpList.add(nums[i]);
            }
            resList.add(tmpList);
            return;
        }

        int tag = Integer.MIN_VALUE;
        for(int i = index; i < end; ++i){
            Arrays.sort(nums, index, end);
            if(nums[i] != tag){
                tag = nums[i];

                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;

                generatePermuteUnique(index + 1);

                tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
    }
}
// @lc code=end

