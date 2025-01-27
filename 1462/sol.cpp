#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
    vector<int> adj[numCourses];
    bitset<100> pre[numCourses];
    vector<int> a(numCourses);
    for (auto p: prerequisites) adj[p[0]].push_back(p[1]), a[p[1]]++;
    queue<int> q;
    for (int i = 0; i < numCourses; i++) if(a[i]==0) q.push(i);
    while(q.size()) {
      int u = q.front();
      q.pop();
      for(int v: adj[u]) {
        pre[v] |= pre[u];
        pre[v].set(u, 1);
        a[v]--;
        if(a[v]==0) q.push(v);
      }
    }
    vector<bool> res;
    for (auto query: queries) {
      int s = query[0], g = query[1];
      res.push_back(pre[g][s]);
    }
    return res;
  }
};