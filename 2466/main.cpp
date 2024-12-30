#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll MOD = 1e9 + 7;

class Solution {
public:
  int countGoodStrings(int low, int high, int zero, int one) {
    ll dp[high+1], res = 0;
    dp[0] = 1;
    for (int i = 1; i <= high; i++){
      dp[i] = 0;
      if(i-zero>=0) dp[i]=(dp[i]+dp[i-zero])%MOD;
      if(i-one>=0) dp[i]=(dp[i]+dp[i-one])%MOD;
      if(i>=low) res = (res + dp[i]) % MOD;
    }
    return res;
  }
};