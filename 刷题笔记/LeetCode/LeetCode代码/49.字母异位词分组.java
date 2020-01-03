import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (59.70%)
 * Likes:    230
 * Dislikes: 0
 * Total Accepted:    42.4K
 * Total Submissions: 70.7K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */
/**
 * 方法一：统计每一个字符出现的次数，最后将次数连接起来成为一个字符串，以此字符串作为 key，构建哈希表
 * 需要注意的是，每一个数字后边需要添加一个标记【如 # 等】,否则可能出错，例如：
 * ["aaaaaaaaaaab","abbbbbbbbbbb"]
 */
// @lc code=start
class Solution {
    private Map<String, List<String>> map = new HashMap<>();
    private int[] countAlphabet = new int[30];

    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            //统计字母出现的次数
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                countAlphabet[c - 'a']++;                
            }

            //生成 key
            StringBuffer tmp = new StringBuffer();
            for (int j = 0; j < countAlphabet.length; j++) {
                tmp.append(countAlphabet[j] + "#");
                //统计完之后恢复
                countAlphabet[j] = 0;
            }
            String key = tmp.toString();

            //存入 Map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }

        //直接 map 转 list
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

// ["aaaaaaaaaaab","abbbbbbbbbbb"]