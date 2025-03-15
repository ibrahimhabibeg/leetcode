#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> nums;
  int n;

  int minCapability(vector<int>& nums, int k) {
    this->nums = nums;
    this->n = nums.size();
    int l = nums[0], h = nums[0];
    for(auto num: nums) l = min(l, num), h = max(h, num);
    while (l<h){
      int m = (l+h)/2;
      if(maxHouses(m)>=k) h = m;
      else l = m+1;
    }
    return l;
  }
  int maxHouses(int v) {
    int i = 0, res = 0;
    while (i<n) {
      if(nums[i]<=v) res++, i+=2;
      else i++;
    }
    return res;
  }
};