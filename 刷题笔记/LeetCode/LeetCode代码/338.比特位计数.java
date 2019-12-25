/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 *
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (73.80%)
 * Likes:    214
 * Dislikes: 0
 * Total Accepted:    22.6K
 * Total Submissions: 30.6K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 */

/**
 * 参照网上的方法，主要有两种，第一种 较为容易想到：
 *  * 位运算
 *  * 根据数字之间的关系，使用动态规划
 *      最后设置位：状态转移方程：res[i] = res[(i & (i - 1))] + 1
 *          注：x & (x - 1) 将 x 的最后低位的 1 变为 0
 *      最高有效位：状态转移方程：P(x + b) = P(x) + 1, b = 2^m > x, 有点难以理解
 *      最低有效位：状态转移方程：P(x) = P( x / 2) + (x mod 2)，也比较好理解 
 */
// @lc code=start
class Solution {
    public int[] countBits(int num) {
        /***********位运算*********** */
        /**
         * 时间复杂度 O(n * sizeof(Integer))
         * 空间复杂度 O(n)
         */
        // int[] res = new int[num + 1];
        // for(int i = 0; i <= num; ++i){
        //     int cnt = 0;
        //     int tmp = i;
        //     while(tmp != 0){
        //         if((tmp & 1) == 1){
        //             cnt++;
        //         }
        //         tmp >>= 1;
        //     }
        //     res[i] = cnt;
        // }
        // return res;
        /***********位运算*********** */

        /**********动态规划*********** */
        /**
         * 三种的时间复杂度均为：O(n)
         * 三种的空间复杂度均为：O(n)
         */
        //通过最后设置位
        // int[] res = new int[num + 1];
        // res[0] = 0;
        // if(num > 0){
        //     res[1] = 1;
        // }

        // for(int i = 2; i <= num; ++i){
        //     res[i] = res[(i & (i - 1))] + 1;
        // }

        // return res;

        //通过最高有效位
        // int[] ans = new int[num + 1];
        // int i = 0, b = 1;
        // // [0, b) is calculated
        // while (b <= num) {
        //     // generate [b, 2b) or [b, num) from [0, b)
        //     while(i < b && i + b <= num){
        //         ans[i + b] = ans[i] + 1;
        //         ++i;
        //     }
        //     i = 0;   // reset i
        //     b <<= 1; // b = 2b
        // }
        // return ans;

        //通过最低有效位
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i){
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        }
        return ans;
        /**********动态规划*********** */
    }
}
// @lc code=end

