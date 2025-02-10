#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string clearDigits(string s) {
    int n = s.size(), c = 0;
    string r = "";
    for (int i = n-1; i >= 0; i--){
      if(isDigit(s[i])) c++;
      else if(c) c--;
      else r = s[i] + r;
    }
    return r;
  }

  bool isDigit(char c) {
    return c-'0'>=0 && c-'0'<=9;
  }
};