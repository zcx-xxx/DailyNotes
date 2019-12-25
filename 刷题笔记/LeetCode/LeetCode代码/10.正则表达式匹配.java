/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 *
 * https://leetcode-cn.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.38%)
 * Likes:    813
 * Dislikes: 0
 * Total Accepted:    42.2K
 * Total Submissions: 166.3K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 
 * 
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    private boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new boolean[p.length() + 5][s.length() + 5];
        
        //初始化
        dp[0][0] = true;
        for(int i = 1; i <= s.length(); ++i){
            dp[0][i] = false;
        }

        //dp 打表
        for(int j = 1; j <= p.length(); ++j){
            for(int k = 0; k <= s.length(); ++k){
                //首先判断匹配串为空串的时候
                if(k == 0){
                    //不是 *，表明至少存在一个字符，不可能和空串匹配
                    if(p.charAt(j - 1) != '*'){
                        dp[j][k] = false;
                    } else {      //是 *，判断将前边一个字符去掉，是否可以和空串匹配
                        if(j - 2 >= 0){
                            dp[j][k] = dp[j - 2][k];
                        }
                    }
                } else {        //匹配串非空的时候
                    //当前的两个字符匹配，且子串匹配，表示当前位置的两个字符串匹配
                    if(p.charAt(j - 1) == s.charAt(k - 1) || p.charAt(j - 1) == '.'){
                        dp[j][k] = dp[j - 1][k - 1];
                    } else if(p.charAt(j - 1) != '*'){       //不是 *，还无法匹配成功，失败
                        dp[j][k] = false;
                    } else {         //是 *，则将当前字符重复 0 次、1 次或者多次，只要有一种情况匹配即可
                        //* 的前一个字符和当前匹配串的字符不相同，只能考虑去掉或者重复 1 次
                        if(p.charAt(j - 2) != s.charAt(k - 1) && p.charAt(j - 2) != '.'){
                            dp[j][k] = (dp[j - 1][k] || dp[j - 2][k]);
                        } else {         //* 的前一个字符和匹配串的当前字符相等，需要考虑将 * 的前一个字符重复多次
                            dp[j][k] = (dp[j][k - 1] || dp[j - 1][k] || dp[j - 2][k]);
                        }
                    }
                }
            }
        }
     
        return dp[p.length()][s.length()];
    }
}
// @lc code=end

/*
"aab"\n
"c*a*b"
*/

