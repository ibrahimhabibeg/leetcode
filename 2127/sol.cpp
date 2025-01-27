#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  vector<int> a, s, t;
  int time, res;
  vector<bool> isCycle;
  vector<vector<int>> adj;

  int maximumInvitations(vector<int>& favorite) {
    a = favorite;
    int n = favorite.size();
    s = vector<int>(n), t = vector<int>(n), isCycle = vector<bool>(n), adj = vector<vector<int>>(n);
    time = 0, res = 0;
    for (int i = 0; i < n; i++) dfs(i), adj[a[i]].push_back(i);
    int res2 = 0;
    for (int i = 0; i < n; i++) if(a[a[i]]==i && i < a[i]) res2 += depth(i) + depth(a[i]);
    return max(res, res2);
  }

  void dfs(int u) {
    if(s[u]==2) return;
    if(s[u]==0) t[u] = time++;
    if(s[u]==1) res = max(res, time-t[u]), isCycle[u] = true;
    s[u]++;
    dfs(a[u]);
    s[u] = 2;
  }

  int depth(int u) {
    int d = 1;
    for (int v: adj[u]) if(!isCycle[v]) d = max(d, 1 + depth(v));
    return d;
  }
};

int main() {
  Solution sol;
  vector<int> a = {1,0,0,2,1,4,7,8,9,6,7,10,8};
  cout << sol.maximumInvitations(a) << endl;
}