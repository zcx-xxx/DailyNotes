/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (41.72%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    68.3K
 * Total Submissions: 163.5K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
/**
 * 先将所有的字符转换为小写，然后扫一遍
 */
// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // System.out.println(s);

        for(int i = 0, j = s.length() - 1; i < j; ){
            char ic = s.charAt(i);
            char jc = s.charAt(j);

            if(!((ic >= 'a' && ic <= 'z') || (ic >= '0' && ic <= '9'))){
                i++;
                continue;
            }
            if(!((jc >= 'a' && jc <= 'z') || (jc >= '0' && jc <= '9'))){
                j--;
                continue;
            }
            // System.out.println(ic + " " + jc);
            if(ic != jc){
                return false;
            } else {
                // System.out.println(ic + " " + jc);
                i++;
                j--;
            }
        }

        return true;
    }
}
// @lc code=end

