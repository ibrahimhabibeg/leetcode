#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int longestMonotonicSubarray(vector<int>& nums) {
    int res = 1, len = 1;
    for (int i = 1; i < nums.size(); i++){
      len = nums[i] > nums[i-1] ? len+1 : 1;
      res = max(res, len);
    }
    len = 1;
    for (int i = 1; i < nums.size(); i++){
      len = nums[i] < nums[i-1] ? len+1 : 1;
      res = max(res, len);
    }
    return res;
  }
};