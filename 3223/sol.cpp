#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int minimumLength(string s) {
    int a[26], res = 0;
    for (int i = 0; i < 26; i++) a[i] = 0;
    for(char c: s) a[c-'a']++;
    for (int i = 0; i < 26; i++) if(a[i]) res += a[i]%2?1:2;
    return res;
  }
};