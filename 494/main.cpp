#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> nums;
  map<pair<int, int>, int> memo;

  int findTargetSumWays(vector<int>& nums, int target) {
    this->nums = nums;
    return dp(0, target);
  }

  int dp(int i, int sum) {
    if (i == nums.size()) return sum == 0 ? 1 : 0;
    if (memo.find({i, sum}) != memo.end()) return memo[{i, sum}];
    memo[{i, sum}] = dp(i + 1, sum - nums[i]) + dp(i + 1, sum + nums[i]);
    return memo[{i, sum}];
  }
};

int main() {
  Solution s;
  vector<int> nums = {1};
  cout << s.findTargetSumWays(nums, 1) << endl;
  return 0;
}