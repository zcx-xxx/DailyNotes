import java.math.BigInteger;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (51.53%)
 * Likes:    275
 * Dislikes: 0
 * Total Accepted:    53.4K
 * Total Submissions: 103.5K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        /****************** 硬算 ****************** */
        // StringBuffer res = new StringBuffer();
        // int tag = 0;
        // int i, j;
        
        // for(i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; --i, --j){
        //     int aa = a.charAt(i) - '0';
        //     int bb = b.charAt(j) - '0';
        //     res.insert(0, (aa + bb + tag) % 2);
        //     tag = (aa + bb + tag) / 2;
        // }
        
        // while(i >= 0){
        //     int aa = a.charAt(i) - '0';
        //     res.insert(0, (aa + tag) % 2);
        //     tag = (aa + tag) / 2;
        //     i--;
        // }
        // while(j >= 0){
        //     int bb = b.charAt(j) - '0';
        //     res.insert(0, (bb + tag) % 2);
        //     tag = (bb + tag) / 2;
        //     j--;
        // }
        // while(tag > 0){
        //     res.insert(0, tag % 2);
        //     tag /= 2;
        // }
        
        // return res.toString();
        /****************** 硬算 ****************** */

        /**************** 借助工具类 *************** */
        //越界
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        /**************** 借助工具类 *************** */
    }
}
// @lc code=end

