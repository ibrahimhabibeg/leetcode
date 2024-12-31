#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
  int mincostTickets(vector<int> &days, vector<int> &costs)
  {
    vector<int> dp(365 + 1);
    vector<bool> a(365 + 1);
    for (int day : days) a[day] = true;
    for (int i = 1; i <= 365; i++) {
      dp[i] = a[i] ? min(costs[0] + dp[i - 1], min(costs[1] + dp[max(0, i - 7)], costs[2] + dp[max(0, i - 30)]))
                   : dp[i - 1];
    }
    return dp[365];
  }
};

int main()
{
  Solution s;
  vector<int> days = {1, 4, 6, 7, 8, 20};
  vector<int> costs = {2, 7, 15};
  cout << s.mincostTickets(days, costs) << endl;
  return 0;
}