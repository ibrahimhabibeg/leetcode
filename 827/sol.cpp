#include <bits/stdc++.h>

using namespace std;

class Solution {
public:

  vector<vector<int>> a;
  vector<vector<int>> c;
  int n;

  int largestIsland(vector<vector<int>>& grid) {
    // 0. Initialize shared variables
    n = grid.size();
    a = grid;
    c = vector(n, vector<int>(n));
    
    // 1. Create Connected Components
    int color = 0;
    for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) if(grid[i][j] && !c[i][j]) colorize(i, j, ++color);
    
    // 2. Calc Connected Components Sizes
    vector<int> s(color+1);
    for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) s[c[i][j]]++;
    
    // 3. Add land to each water cell and recalculate sizes
    int res = 0;
    vector<vector<int>> adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) if(!a[i][j]) {
      set<int> islands;
      for(auto p: adj) {
        int x = i + p[0], y = j + p[1];
        if(min(x, y) >= 0 && max(x, y) < n && c[x][y]) islands.insert(c[x][y]);
      }
      int sum = 1;
      for(auto island: islands) sum += s[island];
      res = max(res, sum);
    }
    return res == 0 ? n*n : res;
  }

  void colorize(int i, int j, int color) {
    if(min(i, j)<0 || max(i, j) >= n || !a[i][j] || c[i][j]) return;
    c[i][j] = color;
    vector<vector<int>> adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for(auto p: adj) colorize(i+p[0], j+p[1], color);
  }
};
