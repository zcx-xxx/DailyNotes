/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (51.65%)
 * Likes:    665
 * Dislikes: 0
 * Total Accepted:    108.2K
 * Total Submissions: 209.1K
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 
 */
/**
 * 1.最简单暴力
 */
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /************* 暴力 ************ */
        // int res = 0;
        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         if(prices[j] - prices[i] > res){
        //             res = prices[j] - prices[i];
        //         }
        //     }
        // }
        // return res;
        /************* 暴力 ************ */

        /************* 动态规划 ************* */
        // //特殊判断
        // if(prices == null || prices.length == 0){
        //     return 0;
        // }
        // //预处理
        // for(int i = prices.length - 1; i > 0; --i){
        //     prices[i] = prices[i] - prices[i - 1];
        // }
        // prices[0] = 0;

        // int max = 0;
        // int res = 0;
        // for(int i = 0; i < prices.length; ++i){
        //     if(res >= 0){
        //         res += prices[i];
        //         if(res > max){
        //             max = res;
        //         }
        //     }
        //     if(res < 0){
        //         res = 0;
        //     }
        // }

        // return max;
        /************* 动态规划 ************* */

        /************* 贪心[官方题解] ************** */
        int maxProfit = 0;       //记录可以获取的最大利益
        int minPrice = Integer.MAX_VALUE;        //记录当前的最小价值

        for(int i = 0; i < prices.length; ++i){
            // System.out.println(minPrice);
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }

            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
        /************* 找规律[官方题解] ************** */
    }
}
// @lc code=end

