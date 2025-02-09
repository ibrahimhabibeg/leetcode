#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  long long countBadPairs(vector<int>& nums) {
    int n = nums.size();
    map<int, long long> mp;
    for (int i = 0; i < n; i++) mp[nums[i]-i]++;
    long long res = n*1ll*(n-1)/2;
    for(auto [k, v]: mp) res -= v*(v-1)/2;
    return res;
  }
};