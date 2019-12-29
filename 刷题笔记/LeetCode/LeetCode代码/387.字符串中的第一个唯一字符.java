/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (42.19%)
 * Likes:    164
 * Dislikes: 0
 * Total Accepted:    53.9K
 * Total Submissions: 127.7K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */
/**
 * 开一个大小为 30 的数组，统计每一个字符出现的次数，然后再遍历一遍，找到第一个出现一次的字符
 */
// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[30];

        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            int index = c - 'a';
            arr[index]++;
        }
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            int index = c - 'a';
            if(arr[index] == 1){
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

