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
    vector<int> largestValues(TreeNode* root) {
      vector<int> res;
      if(!root) return res;
      queue<TreeNode*> q;
      q.push(root);
      while(!q.empty()) {
        int sz = q.size();
        int mx =  q.front()->val;
        while (sz--) {
          TreeNode* u = q.front();
          mx = max(mx,u->val);
          if(u->right) q.push(u->right);
          if(u->left) q.push(u->left);
          q.pop();
        }
        res.push_back(mx);
      }
      return res;
    }
};