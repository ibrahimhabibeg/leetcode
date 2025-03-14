#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

class Solution
{
public:
  vector<int> candies;
  ll noChildren;

  int maximumCandies(vector<int> &candies, ll k)
  {
    this->candies = candies;
    this->noChildren = k;
    ll l = 0, h = 0;
    for(auto candy : candies) h += candy;
    while(l<h) { 
      ll c = (l+h+1)/2;
      if(isPossibleWithCEach(c)) l = c;
      else h = c-1;
    }
    return l;
  }

  bool isPossibleWithCEach(ll c) {
    ll s = 0;
    for(auto candy : candies) s += candy / c;
    return s>=noChildren;
  }
};