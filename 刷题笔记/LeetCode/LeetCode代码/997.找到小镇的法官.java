/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[][] graph = new int[2][N + 5];   //第一行表示入度，第二行表示出度

        for(int i = 0; i < trust.length; ++i){
            graph[0][trust[i][1]]++;
            graph[1][trust[i][0]]++;
        }

        for(int i = 1; i <= N; ++i){
            if(graph[0][i] == N - 1 && graph[1][i] == 0){
                return i;
            }
        }

        return -1;
    }
}

