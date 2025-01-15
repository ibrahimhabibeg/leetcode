#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  int minimizeXor(int num1, int num2) {
    int cnt = 0;
    while (num2) cnt+=num2%2, num2/=2;
    vector<int> a;
    while(num1) a.push_back(num1%2), num1/=2;
    int n = a.size(), i = n-1, res = 0;
    vector<int> r(n);
    while(i>=0 && cnt) cnt-=a[i], r[i] = a[i], i--;
    i = 0;
    while (i<n && cnt) cnt-=1-r[i], r[i] = 1, i++;
    while(cnt) r.push_back(1), cnt--;
    for (int i = 0; i < r.size(); i++) res += r[i]<<i;
    return res;
  }
};


int main() {
  Solution s;
  cout << s.minimizeXor(1, 12) << endl;
  return 0;
}