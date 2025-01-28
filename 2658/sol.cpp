#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int m, n;
  vector<vector<int>> a, c;

  int findMaxFish(vector<vector<int>>& grid) {
    m = grid.size(), n = grid[0].size(), a = grid;
    c = vector<vector<int>>(m, vector<int>(n));
    int cc = 1;
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if(a[i][j] && !c[i][j])
      dfs(i, j, cc++);
    vector<int> s(cc);
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) s[c[i][j]]+=a[i][j];
    int res = 0;
    for (int i = 1; i < cc; i++) res = max(res, s[i]);
    return res;
  }

  void dfs(int i, int j, int cc) {
    if(i<0 || i>=m || j<0 || j>=n || c[i][j] || a[i][j]==0) return;
    c[i][j] = cc;
    vector<vector<int>> vs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (auto v: vs) dfs(i+v[0], j+v[1], cc);
  }
};