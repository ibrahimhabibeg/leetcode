#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int minCost(vector<vector<int>>& grid) {
    int m = grid.size(), n = grid[0].size(), c[m][n];
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) c[i][j] = m+n+10;
    c[m-1][n-1] = 0;
    set<tuple<int, int, int>> q;
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) q.insert(make_tuple(c[i][j], i, j));
    while(!q.empty()) {
      auto v = *q.begin();
      q.erase(q.begin());
      int i = get<1>(v), j = get<2>(v), ni, nj;
      
      if(i+1 < m) {
        ni = i+1, nj = j;

        int nc = c[i][j] + (grid[ni][nj]==4?0:1);
        if(nc<c[ni][nj]) {
          q.erase(make_tuple(c[ni][nj], ni, nj));
          c[ni][nj] = nc;
          q.insert(make_tuple(c[ni][nj], ni, nj));
        }
      }

      if(i-1 >= 0) {
        ni = i-1, nj = j;

        int nc = c[i][j] + (grid[ni][nj]==3?0:1);
        if(nc<c[ni][nj]) {
          q.erase(make_tuple(c[ni][nj], ni, nj));
          c[ni][nj] = nc;
          q.insert(make_tuple(c[ni][nj], ni, nj));
        }
      }

      if(j+1 < n) {
        ni = i, nj = j+1;

        int nc = c[i][j] + (grid[ni][nj]==2?0:1);
        if(nc<c[ni][nj]) {
          q.erase(make_tuple(c[ni][nj], ni, nj));
          c[ni][nj] = nc;
          q.insert(make_tuple(c[ni][nj], ni, nj));
        }
      }

      if(j-1 >= 0) {
        ni = i, nj = j-1;

        int nc = c[i][j] + (grid[ni][nj]==1?0:1);
        if(nc<c[ni][nj]) {
          q.erase(make_tuple(c[ni][nj], ni, nj));
          c[ni][nj] = nc;
          q.insert(make_tuple(c[ni][nj], ni, nj));
        }
      }
    }
    return c[0][0];
  }
};