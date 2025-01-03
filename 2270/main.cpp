#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

class Solution {
public:
  int waysToSplitArray(vector<int>& nums) {
    int n = nums.size(), res = 0;
    ll s[n];
    s[0] = nums[0];
    for (int i = 1; i < n; i++) s[i] = s[i-1] + 1ll * nums[i];
    for (int i = 0; i < n-1; i++) if(2*s[i] > s[n-1]) res++;
    return res;
  }
};