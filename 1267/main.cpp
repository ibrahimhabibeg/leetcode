#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int countServers(vector<vector<int>>& grid) {
    int res = 0, m = grid.size(), n = grid[0].size();
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if(grid[i][j]) {
      int communicates = 0;
      for (int k = 0; k < n; k++) if(k!=j && grid[i][k]) communicates = 1;
      for (int k = 0; k < m; k++) if(k!=i && grid[k][j]) communicates = 1;
      res+=communicates; 
    }
    return res;
  }
};