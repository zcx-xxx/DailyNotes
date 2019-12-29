import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 *
 * https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
 *
 * algorithms
 * Medium (78.57%)
 * Likes:    4
 * Dislikes: 0
 * Total Accepted:    2.2K
 * Total Submissions: 2.8K
 * Testcase Example:  '[3,3,3,3,3,1,3]'
 *
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组
 * groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * 
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释： 
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * 
 * 
 * 示例 2：
 * 
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 * 
 * 
 */
/**
 * 重要的前提是题目已经告诉肯定有解
 * 首先建一个 person 类，保存所在组的大小和 id 的对应关系，然后排序
 * 最后扫描一遍记录结果，
 */
// @lc code=start
class Solution {
    private Person[] persons;
    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        persons = new Person[groupSizes.length];

        for(int i = 0; i < groupSizes.length; ++i){
            persons[i] = new Person();
            persons[i].id = i;
            persons[i].size = groupSizes[i];
        }

        Arrays.sort(persons);

        for(int i = 0; i < persons.length; ){
            List<Integer> tmpList = new ArrayList<>();
            for(int j = i; j < i + persons[i].size; ++j){
                tmpList.add(persons[j].id);
            }
            resList.add(tmpList);
            //直接跳是因为保证有正确答案
            i += persons[i].size;
        }
        /** */
        // for(int i = 0; i < persons.length; ++i){
        //     System.out.println(persons[i].size);
        // }
        /** */

        return resList;
    }

    /**
     * 实现 Person 类
     */
    private class Person implements Comparable<Person>{
        public Integer id;
        public Integer size;

        @Override
        public int compareTo(Person o) {
            return this.size - o.size;
        }
    }
}
// @lc code=end

