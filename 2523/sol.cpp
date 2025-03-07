#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> closestPrimes(int left, int right) {
    vector<int> sieve(right+1), primes;
    for (int p = 2; p <= right; p++) if (!sieve[p]){
      if(p>=left) primes.push_back(p);
      for (int i = p+p; i <= right; i+=p) sieve[i]++;
    } 
    int n = primes.size(), diff = 1e9, j = 0;
    if(n<2) return {-1, -1};
    for (int i = 0; i < n-1; i++) if(diff>primes[i+1]-primes[i]) j = i, diff = primes[i+1] - primes[i];
    return {primes[j], primes[j+1]};
  }
};