#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
    int n = grid.size(), a, b;
    vector<int> cnt(n*n+1);
    for(auto v: grid) for(auto x: v) cnt[x]++;
    for (int i = 1; i <= n*n; i++) {
      if(cnt[i]==2) a = i;
      else if(cnt[i]==0) b = i;
    }
    return {a, b};
  }
};