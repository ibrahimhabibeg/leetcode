#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
      int res = 0, p = values[0];
      for (int j = 1; j < values.size(); j++) {
        res = max(res, p + values[j] - j);
        p = max(p, values[j] + j);
      }
      return res;
    }
};