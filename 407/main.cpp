#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int trapRainWater(vector<vector<int>>& heightMap) {
    int m = heightMap.size(), n = heightMap[0].size(), h[m+2][n+2], w[m+2][n+2];
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) h[i+1][j+1] = heightMap[i][j];
    for (int i = 1; i <= m; i++) for (int j = 1; j <= n; j++) w[i][j] = 2e4 + 5;
    for (int i = 0; i < m+2; i++) h[i][0] = w[i][0] = h[i][n+1] = w[i][n+1] = 0;
    for (int j = 0; j < n+2; j++) h[0][j] = w[0][j] = h[m+1][j] = w[m+1][j] = 0;
    set<vector<int>> s;
    for (int i = 0; i < m+2; i++) for (int j = 0; j < n+2; j++) s.insert({h[i][j] + w[i][j], i, j});
    while (!s.empty()) {
      auto p = *s.begin();
      s.erase(s.begin());
      int a = p[1], b = p[2];
      vector<vector<int>> adj;
      if(a>=1) adj.push_back({a-1, b});
      if(a<=m) adj.push_back({a+1, b});
      if(b>=1) adj.push_back({a, b-1});
      if(b<=n) adj.push_back({a, b+1});
      for(auto v: adj){
        int c = v[0], d = v[1], newW = max(0, w[a][b] + h[a][b] - h[c][d]);
        if(newW<w[c][d]) {
          s.erase({h[c][d] + w[c][d], c, d});
          w[c][d] = newW;
          s.insert({h[c][d] + w[c][d], c, d});
        }
      }
    }
    int res = 0;
    for (int i = 0; i < m+2; i++) for (int j = 0; j < n+2; j++) res += w[i][j];
    return res;
  }
};

int main(){

  vector<vector<int>> heightMap = {{1, 4, 3, 1, 3, 2},
                                   {3, 2, 1, 3, 2, 4},
                                   {2, 3, 3, 2, 3, 1}};
  Solution sol;
  cout << sol.trapRainWater(heightMap) << endl;
  return 0;
}