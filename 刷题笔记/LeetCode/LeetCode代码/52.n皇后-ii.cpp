#include <bits/stdc++.h>
/*
 * @lc app=leetcode.cn id=52 lang=cpp
 *
 * [52] N皇后 II
 */
class Solution {
public:
    int arr[100][100];
    int res = 0;
    int k = 0;

public:
    int totalNQueens(int n) {
        memset(arr, 0, sizeof arr);
        k = n;
        fun(0, n);
        return res;
    }

    int Judge(int row, int col){
        if(row < 0 || row >= k || col < 0 || col >= k){
            return 0;
        }

        for(int i = row; i >= 0; --i){
            if(arr[i][col] == 1){
                return 0;
            }
        }
        for(int i = row, j = col; i >= 0 && j >= 0; --i, --j){
            if(arr[i][j] == 1){
                return 0;
            }
        }
        for(int i = row, j = col; i >= 0 && j < k; --i, ++j){
            if(arr[i][j] == 1){
                return 0;
            }
        }

        return 1;
    }

    void fun(int row, int n){
        if(row == n){
            res++;
            return;
        }

        for(int i = 0; i < n; ++i){
            if(Judge(row, i)){
                arr[row][i] = 1;
                fun(row + 1, n);
                arr[row][i] = 0;
            }
        }
    }
};

