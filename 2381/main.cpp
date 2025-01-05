#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  string shiftingLetters(string s, vector<vector<int>>& shifts) {
    int n = s.length();
    vector<int> a(n+1);
    for (auto f: shifts) a[f[0]] += f[2]? 1: - 1,  a[f[1]+1] -= f[2]? 1: - 1;
    for (int i = 1; i < n; i++) a[i] += a[i-1];
    for (int i = 0; i < n; i++) s[i] = ((((s[i] - 'a' + a[i])%26)+26)%26) + 'a';
    return s;
  }
};

int main() {
  Solution s;
  string str = "abc";
  vector<vector<int>> shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
  cout << s.shiftingLetters(str, shifts) << endl;
  return 0;
}