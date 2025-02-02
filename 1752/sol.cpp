#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  bool check(vector<int>& a) {
    int n = a.size(), cnt = 0;
    for (int i = 0; i < n; i++) cnt += a[i] > a[(i+1)%n];
    return cnt <= 1;
  }
};