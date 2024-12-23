#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:

    int minimumOperations(TreeNode* root) {
      queue<TreeNode*> q;
      q.push(root);
      int res = 0;
      while (!q.empty()){
        vector<int> a;
        int sz = q.size();
        for (int i = 0; i < sz; i++) {
          a.push_back(q.front()->val);
          if(q.front()->left) q.push(q.front()->left);
          if(q.front()->right) q.push(q.front()->right);
          q.pop();
        }
        int n = a.size();
        res+=n;
        bool vis[n];
        pair<int, int> b[n];
        for (int i = 0; i < n; i++) b[i] = make_pair(a[i], i), vis[i] = false;
        sort(b, b+n);
        for (int i = 0; i < n; i++) if(!vis[i]){
          res--;
          int j = i;
          while (!vis[j]) vis[j] = true, j = b[j].second;
        }
      }
      return res;
    }
};