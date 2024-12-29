#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const ll MOD = 1e9 + 7;

class Solution {
public:
  int numWays(vector<string>& words, string target) {
    int n = words[0].size(), m = target.size();
    target = ' ' + target;
    for(int i = 0; i < words.size(); i++) words[i] = ' ' + words[i];
    vector<int> t(m+1);
    for (int i = 1; i <= m; i++) t[i] = target[i] - 'a';
    vector<vector<ll>> mp(n+1, vector<ll>(26));
    for(auto word : words) for (int i = 1; i <= n; i++) mp[i][word[i]-'a']++;
    vector<ll> dp(n+1, 1);
    for (int j = 1; j<=m; j++) {
      vector<ll> ndp(n+1);
      for (int i = 1; i <= n; i++) ndp[i] = (ndp[i-1] + mp[i][t[j]]*dp[i-1]) % MOD;
      dp = ndp;
    }
    return dp[n];
  }
};