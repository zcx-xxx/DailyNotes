/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (41.05%)
 * Likes:    247
 * Dislikes: 0
 * Total Accepted:    37.7K
 * Total Submissions: 91.6K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */
/**
 * 想到的也只有死算了，写一个计算多为乘一位的，再写一个加法，用一个计数器每次累加
 */
// @lc code=start
class Solution {
    private String res = new String("0");
    public String multiply(String num1, String num2) {
        //保证第一个数的长度不小于第二个
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        //计算
        for (int i = num2.length() - 1; i >= 0; --i) {
            String tmp = multiplyBigInteger(num1, num2.charAt(i) + "");
            /***** */
            System.out.println(tmp);
            /***** */
            res = addBigInteger(tmp, res);
            num1 += "0";
        }

        return res;
    }

    /**
     * 计算大整数加法
     * @param num1
     * @param num2
     * @return
     */
    public String addBigInteger(String num1, String num2) {
        int carry = 0, i = 0, j = 0;
        StringBuffer buffer = new StringBuffer();

        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; --i, --j) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(j);

            int tmp = (c1 - '0') + (c2 - '0') + carry;
            buffer.insert(0, tmp % 10);
            carry = tmp / 10;
        }
        
        while (i >= 0) {
            char c1 = num1.charAt(i);
    
            int tmp = (c1 - '0') + carry;
            buffer.insert(0, tmp % 10);
            carry = tmp / 10;
            i--;
        }
        while (j >= 0) {
            char c2 = num2.charAt(j);
    
            int tmp = (c2 - '0') + carry;
            buffer.insert(0, tmp % 10);
            carry = tmp / 10;
            j--;
        }

        if (carry > 0) {
            buffer.insert(0, carry);
        }

        return buffer.toString();
    }

    /**
     * 实现了一位数乘以多位数
     * @param num1
     * @param num2
     * @return
     */
    public String multiplyBigInteger(String num1, String num2) {
        if (num2.equals("0")) {
            return "0";
        } else if (num2.equals("1")) {
            return num1;
        }

        int carry = 0;
        char c2 = num2.charAt(0);
        StringBuffer buffer = new StringBuffer();

        for (int i = num1.length() - 1; i >= 0; i--) {
            char c1 = num1.charAt(i);
            int tmp = (c1 - '0') * (c2 - '0') + carry;
            buffer.insert(0, tmp % 10);
            carry = tmp / 10;
        }

        if (carry > 0) {
            buffer.insert(0, carry);
        }

        return buffer.toString();
    }
}
// @lc code=end

