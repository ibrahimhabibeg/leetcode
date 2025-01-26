#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
  vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
    vector<int> a(nums);
    sort(a.begin(), a.end());
    map<int, int> mp;
    int c = 0;
    mp[a[0]] = c;
    vector<multiset<int>*> v;
    v.push_back(new multiset<int>);
    v[0]->insert(a[0]);
    for (int i = 1; i < a.size(); i++){
      if(a[i]-a[i-1]>limit) c++, v.push_back(new multiset<int>);
      mp[a[i]] = c, v[c]->insert(a[i]);
    }
    vector<int> res(nums.size());
    for (int i = 0; i < res.size(); i++){
      res[i] = *v[mp[nums[i]]]->begin();
      v[mp[nums[i]]]->erase(v[mp[nums[i]]]->begin());
    }
    return res;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {1, 7, 6, 18, 2, 1};
  int limit = 2;
  vector<int> res = sol.lexicographicallySmallestArray(nums, limit);
  for (int i = 0; i < res.size(); i++) {
    cout << res[i] << " ";
  }
  cout << endl;
  return 0;
}