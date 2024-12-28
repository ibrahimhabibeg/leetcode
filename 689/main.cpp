#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> maxSumOfThreeSubarrays(vector<int>& a, int k) {
    int n = a.size(), dp[n][4], s = 0, p[n][4];
    for (int i = 0; i < n; i++) for (int j = 0; j < 4; j++) dp[i][j] = 0;
    for (int i = 0; i < n; i++) {
      s+=a[i];
      if(i>=k) s-=a[i-k];
      for (int j = 1; j <= 3; j++) {
        dp[i][j] = s;
        if(i>=k) dp[i][j] += dp[i-k][j-1];
        p[i][j] = i;
        if(i>0 && dp[i-1][j]>=dp[i][j]) {
          dp[i][j] = dp[i-1][j];
          p[i][j] = p[i-1][j];
        }
      }
    }
    vector<int> res(3);
    int x = n-1+k;
    for (int i = 3; i > 0; i--){
      x = p[x-k][i];
      res[i-1] = x-k+1;
    }    
    return res;
  }
};

int main() {
  Solution solution;
  vector<int> a = {1,2,1,2,6,7,5,1};
  int k = 2;
  vector<int> ans = solution.maxSumOfThreeSubarrays(a, k);
  for (int x : ans) cout << x << " ";
  cout << endl;
  return 0;
}