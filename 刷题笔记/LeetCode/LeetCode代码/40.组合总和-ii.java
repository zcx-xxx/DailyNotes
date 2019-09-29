import java.util.*;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */
class Solution {
    public List<List<Integer>> resList = new ArrayList<>();
    public int target = 0;
    public int[] candidates = null;
    public int len = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;    
        this.len = candidates.length;

        Arrays.sort(candidates);
        dfs(new ArrayList<Integer>(), 0, 0);

        return resList;
    }

    /**
     * 对数组元素进行深搜
     * @param list 保存已经取的元素
     * @param level 表示元素的开始下标
     * @param sum 表示当前已选元素的总和
     */
    public void dfs(List<Integer> list, int level, int sum){
        if(sum == target){
            resList.add(new ArrayList<>(list));
            return;
        } else if(sum > target){
            return;
        }

        for(int i = level; i < len; ++i){
            if(i > level && candidates[i - 1] == candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            dfs(list, i + 1, sum + candidates[i]);
            list.remove(list.size() - 1);
        }

        return;
    }
}

