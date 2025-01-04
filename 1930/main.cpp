#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int countPalindromicSubsequence(string s) {
    int res = 0, n = s.size(), l, r;
    for (int i = 0; i < 26; i++){
      char c = 'a' + i;
      l = 0, r = n-1;
      while (l<n && s[l]!=c) l++;
      while (r>=0 && s[r]!=c) r--;
      int mp = 0;
      for (int j = l+1; j < r; j++) {
        int b = 1 << (s[j]-'a');
        if(!(b&mp)) res++;
        mp |= b;
      }
    }
    return res;
  }
};