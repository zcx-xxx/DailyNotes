import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (71.79%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    28.1K
 * Total Submissions: 39.2K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */
/**
 * 直接枚举开头的数字
 */
// @lc code=start
class Solution {
    private int n;
    private int[] arr;
    private List<List<Integer>> resList = new ArrayList<>();
    private int k;
    private int index = 0;          //标记 arr 数组的下标

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n + 5];
        init();

        getCombine(1, k);

        return resList;
    }

    /**
     * 初始化
     */
    public void init(){
        for(int i = 0; i < arr.length; ++i){
            arr[i] = i;
        }
    }
    /**
     * 从 start 开始枚举起点
     * @param start
     * @param cnt
     */
    public void getCombine(int start, int cnt){
        //还需要的数为 0 个，记录结果，结束
        if(cnt == 0){
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                tmpList.add(arr[i]);
            }
            resList.add(tmpList);        
            return;
        }
        //开始的位置已经不足以构成组合的个数，结束
        if(start > n - cnt + 1){
            return;
        }
        //枚举当前位置的元素
        for(int i = start; i <= n - cnt + 1; ++i){
            arr[index++] = i;
            getCombine(i + 1, cnt - 1);
            index--;
        }
    }
}
// @lc code=end

