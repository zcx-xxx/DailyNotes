import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 *
 * https://leetcode-cn.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (66.98%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    16K
 * Total Submissions: 23.9K
 * Testcase Example:  '2'
 *
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * 
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 
 * 示例 2:
 * 
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 * 
 * 
 */
/**
 * 方法一(最差的)：回溯法
 *      花了几个小时想出来的，虽然效率不行，总归过了，思路就是回溯的时候改变当前二进制位的状态，改变之后若未被访问，则改变然后递归，否则不改变，直接递归（优点凭直觉做的，画一个图容易发现规律）
 * 方法二：动态规划
 *      长度位 (n + 1) 的格雷码，在长度为 n 的格雷码的基础上【倒序遍历,前边加一】即可
 *          0 00
 *          0 01
 *          0 11
 *          0 10
 * ----------------------- 上下对称，只用加 1 就好，加了 0 等于没加
 *          1 10
 *          1 11
 *          1 01
 *          1 00
 * 方法三：直接推导
 *      初始化开始为 0，
 *      然后依次：
 *          1. 改变上一项二进制表示的【最右边的位元】
 *          2. 改变上一项二进制表示中【最右边为 1 的位元】的【左边的一位】的状态
 *      以 n = 3 为例：
 *          0 0 0 第零项初始化为 0。
 *          0 0 1 第一项改变上一项最右边的位元
 *          0 1 1 第二项改变上一项右起第一个为 1 的位元的左边位
 *          0 1 0 第三项同第一项，改变上一项最右边的位元
 *          1 1 0 第四项同第二项，改变最上一项右起第一个为 1 的位元的左边位
 *          1 1 1 第五项同第一项，改变上一项最右边的位元
 *          1 0 1 第六项同第二项，改变最上一项右起第一个为 1 的位元的左边位
 *          1 0 0 第七项同第一项，改变上一项最右边的位元
 * 方法四：公式法
 *      n 的格雷码为 (n ^ (n >> 1))
 */
// @lc code=start
class Solution {
    private List<Integer> resList = new ArrayList<>();
    private BitSet bitSet = null;
    private int value = 0;

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            resList.add(0);
            return resList;
        }

        /********** 回溯法 ********** */
        // bitSet = new BitSet((1 << n) + 5);
        // dfs(n - 1);
        /********** 回溯法 ********** */

        /********* 动态规划 ********* */
        //外层 for 循环表示求长度为 i 的格雷码
        // resList.add(0);
        // for (int i = 0; i < n; ++i) {
        //     int index = resList.size() - 1;
        //     while (index >= 0){
        //         resList.add(resList.get(index) + (1 << i));
        //         index--;
        //     }
        // }
        /********* 动态规划 ********* */

        /********* 直接推导 ********* */
        // resList.add(0);
        // for (int i = 1; i < (1 << n); ++i) {
        //     int tmp = resList.get(i - 1);
        //     if ((i & 1) == 1) {
        //         resList.add(tmp ^ 1);
        //     } else {
        //         resList.add(tmp ^ ((tmp & -tmp) << 1));
        //     }
        // }
        /********* 直接推导 ********* */

        /********* 公式法 ********* */
        for (int i = 0; i < (1 << n); ++i) {
            resList.add(i ^ (i >> 1));
        }
        /********* 公式法 ********* */
        return resList;
    }

    /**
     * 深搜
     * @param deep
     */
    public void dfs(int deep) {
        if (deep < 0) {
            resList.add(value);
            return;
        }

        dfs(deep - 1);
        if (!bitSet.get(value ^ (1 << deep))) {
            value ^= (1 << deep);
        }
        dfs(deep - 1);
    }
}
// @lc code=end
// [0,1,3,4,2,6,7,9,10,8,16,17,19,20,18,22,23,25,26,24]

