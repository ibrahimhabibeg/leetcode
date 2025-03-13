#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
    int sum = 0, n = nums.size(), k = 0, m = queries.size();
    vector<int> d(n+1);
    for (int i = 0; i < n; i++) {
      while(sum+d[i]<nums[i]) {
        if(k==m) return -1;
        int l = queries[k][0], r = queries[k][1], v = queries[k][2];
        d[l]+=v, d[r+1]-=v;
        if(l<i) sum+=v;
        if(r+1<i) sum-=v;
        k++;
      }
      sum+=d[i];
    }
    return k;
  }
};

int main() {
  Solution s;
  vector<int> nums = {1, 0, 6};
  vector<vector<int>> queries = {{1, 2, 1}, {0, 0, 4}, {1, 1, 5}, {0, 0, 5}, {1, 2, 4}, {0, 2, 2}, {2, 2, 4}, {1, 2, 2}, {1, 2, 4}, {0, 1, 3}};
  cout << s.minZeroArray(nums, queries);
}