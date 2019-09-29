import java.util.*;
/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len == 0){
            return 0;
        } else if (len == 1) {
            return triangle.get(0).get(0);
        }

        int[] arr = new int[len];
        arr[0] = triangle.get(0).get(0);
        for(int i = 1; i < len; ++i){
            int cnt = triangle.get(i).size();
            for(int j = cnt - 1; j >= 0; --j){
                if(j == cnt - 1){
                    arr[j] = triangle.get(i).get(j) + arr[j - 1];
                } else if(j == 0){
                    arr[j] += triangle.get(i).get(j);
                } else {
                    arr[j] = Math.min(arr[j], arr[j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        //遍历数组，找最大值
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < len; ++i){
            if(arr[i] < res){
                res = arr[i];
            }
        }

        return res;
    }
}

