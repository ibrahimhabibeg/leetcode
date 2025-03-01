#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<int> applyOperations(vector<int>& a) {
      int n = a.size();  
      vector<int> res;
      for (int i = 0; i < n-1; i++) if(a[i]==a[i+1]) a[i]*=2, a[i+1]=0;
      for (int i = 0; i < n; i++) if(a[i]) res.push_back(a[i]);
      while(res.size()<n) res.push_back(0);
      return res;
    }
  };