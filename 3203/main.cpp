#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int minimumDiameterAfterMerge(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
    int d1 = getMinDiameter(edges1), d2 = getMinDiameter(edges2);
    return max(max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
  }

private:
  int getMinDiameter(vector<vector<int>>& edges) {
    int n = edges.size() + 1;
    vector<int> adj[n];

    for(auto e: edges) adj[e[0]].push_back(e[1]), adj[e[1]].push_back(e[0]);
    bool vis[n];
    for (int i = 0; i < n; i++) vis[i] = false;
    int u;
    queue<int> q;
    q.push(0);
    while (!q.empty()){
      u = q.front();
      int sz = q.size();
      while(sz--) {
        int v = q.front();
        vis[v] = true;
        q.pop();
        for(int w: adj[v]) if(!vis[w]) q.push(w);
      }
    }
    int d = -1;
    q.push(u);
    for (int i = 0; i < n; i++) vis[i] = false;
    while (!q.empty()){
      d++;
      int sz = q.size();
      while(sz--) {
        int v = q.front();
        vis[v] = true;
        q.pop();
        for(int w: adj[v]) if(!vis[w]) q.push(w);
      }
    }
    return d;
  }
};

int main() {
  Solution solution;
  vector<vector<int>> edges1 = {{0, 1}, {0, 2}, {0, 3}};
  vector<vector<int>> edges2 = {{0, 1}};
  cout << solution.minimumDiameterAfterMerge(edges1, edges2) << endl;
  return 0;
}