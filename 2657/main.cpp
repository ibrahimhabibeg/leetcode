#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
    int n = A.size();
    vector<int> c(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) for (int k = 0; k <= i; k++) if(A[j]==B[k]) {
        c[i]++;
        break;
      } 
    }
    return c;
  }
};