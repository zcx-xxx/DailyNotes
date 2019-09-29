import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */
class Solution {
    public List<List<Integer>> resList = new ArrayList<>();
    public int target = 0;
    public int[] candidates;
    public int len = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        this.len = candidates.length;
        dfs(new ArrayList<>(), 0, 0);
        
        return resList;
    }

    public void dfs(ArrayList<Integer> list, int level, int sum){
        if(sum == target){
            resList.add(new ArrayList<>(list));
            return;
        } else if(sum > target){
            return;
        }

        for(int i = level; i < len; ++i){
            list.add(candidates[i]);
            dfs(list, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
        return;
    }
}

