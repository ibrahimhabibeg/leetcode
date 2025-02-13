#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

class Solution {
public:
  int minOperations(vector<int>& nums, int k) {
    multiset<ll> s;
    for (int x: nums) s.insert(x);
    int res = 0;
    while((*s.begin())<k) {
      auto it = s.begin();
      ll x = *it;
      it++;
      ll y = *it;
      s.erase(s.begin());
      s.erase(s.begin());
      s.insert(2*1ll*x+y);
      res++;
    }
    return res;
  }
};