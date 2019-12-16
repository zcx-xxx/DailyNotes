#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    Solution(){}

    int minDistance(string word1, string word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[len1 + 5][len2 + 5];

        //初始化
        memset(dp, 0, sizeof dp);
        for(int i = 0; i <= len1; ++i){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; ++j){
            dp[0][j] = j;
        }

        //dp
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(word1[i - 1] == word2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
};

int main(){
    Solution test;
    int res = test.minDistance("horse", "ros");
    cout << res << endl;
    return 0;
}
