import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.70%)
 * Likes:    527
 * Dislikes: 0
 * Total Accepted:    65.9K
 * Total Submissions: 127.4K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    private String[] telMap = new String[10];        //记录数字和字母的映射
    private List<String> resList = new ArrayList<>();
    private String digits;
    private int end;

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return resList;
        }
        this.digits = digits;
        this.end = digits.length();

        init();
        dfs(0, "");

        return resList;
    }

    /**
     * 深搜
     * @param deep 层数
     * @param buffer 字符串
     */
    public void dfs(int deep, String buffer){
        if(deep == end){
            resList.add(buffer.toString());
            return;
        }

        String str = telMap[digits.charAt(deep) - '0'];
        for (int i = 0; i < str.length(); i++) {
            dfs(deep + 1, buffer + str.charAt(i));
        }
    }

    /**
     * 初始化
     */
    public void init(){
        telMap[2] = "abc";
        telMap[3] = "def";
        telMap[4] = "ghi";
        telMap[5] = "jkl";
        telMap[6] = "mno";
        telMap[7] = "pqrs";
        telMap[8] = "tuv";
        telMap[9] = "wxyz";
    }
}
// @lc code=end

