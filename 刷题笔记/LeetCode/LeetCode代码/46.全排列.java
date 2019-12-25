import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (73.00%)
 * Likes:    480
 * Dislikes: 0
 * Total Accepted:    64.7K
 * Total Submissions: 88.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    private int end;
    private int[] nums;
    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        end = nums.length;
        this.nums = nums;

        generatePermutation(0);

        return resList;
    }

    /**
     * 递归生成全排列
     * @param index
     */
    public void generatePermutation(int index){
        if(index == end){
            List<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < nums.length; ++i){
                tmpList.add(nums[i]);
            }
            resList.add(tmpList);
            return;
        }

        for(int i = index; i < end; ++i){
            Arrays.sort(nums, index, end);
            
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
            
            generatePermutation(index + 1);

            tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }
}
// @lc code=end

