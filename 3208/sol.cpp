#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int numberOfAlternatingGroups(vector<int>& c, int k) {
    int res = 0, b = 0, n = c.size();
    while (b<n && c[b]!=c[(b-1+n)%n]) b++;
    if(b==n) return n;
    int s = 1;
    for (int i = 0; i < n; i++) {
      if(c[b]==c[(b-1+n)%n]) s = 1;
      else s++;
      if(s>=k) res++;
      b = (b+1)%n;
    }
    return res;
  }
};