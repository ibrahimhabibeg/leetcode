#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
  int maximumSum(vector<int>& nums) {
    map<int, multiset<int>> mp;
    for (int x: nums) mp[sumOfDigits(x)].insert(-x);
    int res = -1;
    for (auto [k, s]: mp){
      if(s.size()>=2) {
        int sum = 0;
        auto it = s.begin();
        sum += -(*it);
        it++;
        sum += -(*it);
        res = max(res, sum);
      }
    }
    return res;
  }

  int sumOfDigits(int x){
    int res = 0;
    while (x) res+=x%10, x/=10;
    return res;
  }
};
