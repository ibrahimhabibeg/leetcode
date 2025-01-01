#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int maxScore(string s) {
    int ones = 0, zeros = 0, res = 0;
    for (int i = 0; i<s.length(); i++) ones += s[i]=='1';
    for (int i = 0; i<s.length()-1; i++) {
      zeros += s[i] == '0';
      ones -= s[i] == '1';
      res = max(res, zeros + ones);
    }
    return res;
  }
};