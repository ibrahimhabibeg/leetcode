#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string getHappyString(int n, int k) {
    string s = "";
    k--;
    if (k>=3*(1<<(n-1))) return s;
    s += 'a' + k / (1<<(n-1));
    k %= (1<<(n-1));
    for (int i = 1; i < n; i++) {
      int v = k / (1<<(n-1-i));
      k %= (1<<(n-1-i));
      char c = 'a' + v;
      if (c>=s[i-1]) c++;
      s+=c;
    }
    return s;
  }
};