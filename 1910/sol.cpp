#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string removeOccurrences(string s, string part) {
    int idx = s.find(part);
    while (idx != string::npos) {
      s = s.erase(idx, part.size());
      idx = s.find(part);
    }
    return s;
  }
};