#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string shortestCommonSupersequence(string str1, string str2) {
    int m = str1.length(), n = str2.length(), dp[m+1][n+1], a[m+1][n+1];
    str1 = " " + str1, str2 = " " + str2;
    dp[0][0] = 0;
    // For a
    // 0 is D
    // 1 is L
    // 2 is R
    for (int i = 0; i <= m; i++) for (int j = 0; j <= n; j++) {
      if(i>0 && j>0 && str1[i]==str2[j]) dp[i][j] = dp[i-1][j-1] + 1, a[i][j] = 0;
      else if(j>0 && (i==0 || dp[i][j-1]<=dp[i-1][j])) dp[i][j] = dp[i][j-1] + 1, a[i][j] = 2;
      else if(i>0 && (j==0 || dp[i-1][j]<=dp[i][j-1])) dp[i][j] = dp[i-1][j] + 1, a[i][j] = 1;
    }
    string res = "";
    int x = m, y = n;
    while(x || y) {
      if(a[x][y] == 0) res = str1[x] + res, x-=1, y-=1;
      else if(a[x][y] == 1) res = str1[x] + res, x-=1;
      else res = str2[y] + res, y-=1;
    }
    return res;
  }
};