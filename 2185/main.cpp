#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int prefixCount(vector<string>& words, string pref) {
    int res = 0;
    for (string word: words) res += word.starts_with(pref);
    return res;
  }
};