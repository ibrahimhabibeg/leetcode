#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  bool doesValidArrayExist(vector<int>& derived) {
    int res = 0;
    for(int a: derived) res^=a;
    return res == 0;
  }
};