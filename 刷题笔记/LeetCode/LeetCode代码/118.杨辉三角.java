import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (65.04%)
 * Likes:    218
 * Dislikes: 0
 * Total Accepted:    52.1K
 * Total Submissions: 80K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }
        List<Integer> firList = new ArrayList<>();
        firList.add(1);
        list.add(firList);

        for (int i = 1; i < numRows; ++i) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            List<Integer> preList = list.get(i - 1);

            for (int j = 0; j < preList.size() - 1; j++) {
                tmp.add(preList.get(j) + preList.get(j + 1));
            }

            tmp.add(1);

            list.add(tmp);
        }

        return list;
    }
}
// @lc code=end

