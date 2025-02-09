#include <bits/stdc++.h>
using namespace std;

class NumberContainers {
public:
  set<pair<int, int>> s;
  map<int, int> mp;

  NumberContainers() {}
  
  void change(int index, int number) {
    if(mp[index]) s.erase(make_pair(mp[index], index));
    mp[index] = number;
    s.insert(make_pair(number, index));
  }
  
  int find(int number) {
    auto it = s.lower_bound(make_pair(number, 0));
    if(it==s.end() || (*it).first!=number) return -1;
    return (*it).second;
  }
};