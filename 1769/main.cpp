#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  vector<int> minOperations(string s) {
    int n = s.length(), r = 0, sr = 0, sl =0;
    vector<int> res(n);
    for (int i = 0; i < n; i++) if(s[i] - '0') sr += i, r+=1;
    int c = r;
    for (int i = 0; i < n; i++) {
      res[i] = sr - r*i - sl + (c-r)*i;
      if(s[i] - '0') r-=1, sr-=i, sl+=i;
    }
    return res;
  }
};