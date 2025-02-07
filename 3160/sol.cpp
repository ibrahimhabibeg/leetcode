#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> queryResults(int limit, vector<vector<int>>& queries) {
    int n = queries.size();
    vector<int> result(n);
    map<int, int> mp, a;
    for (int i = 0; i < n; i++) {
      auto q = queries[i];
      if(a[q[0]]) {
        mp[a[q[0]]]--;
        if(!mp[a[q[0]]])mp.erase(a[q[0]]);
      }
      a[q[0]] = q[1];
      mp[a[q[0]]]++;
      result[i] = mp.size();
    }
    return result;
  }
};