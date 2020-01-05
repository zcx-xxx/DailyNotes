import java.util.*;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (59.14%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    33.8K
 * Total Submissions: 57.1K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
/**
 * 将杨辉三角的上一层的数字倒序遍历，arr[i] = arr[i] + arr[i - 1]
 */
// @lc code=start
class Solution {
    private int[] arr = new int[35];

    public List<Integer> getRow(int rowIndex) {
        List<Integer> resList = new ArrayList<>();

        arr[0] = 1;
        int nums = 1;
        //循环生成每一层
        while (--rowIndex >= 0) {
            arr[nums] = 1;
            //倒着遍历
            for (int i = nums - 1; i > 0; --i) {
                arr[i] += arr[i - 1];
            }
            nums++;
        }

        //添加结果
        for (int i = 0; i < nums; i++) {
            resList.add(arr[i]);
        }

        return resList;
    }
}
// @lc code=end

