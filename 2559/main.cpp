#include <bits/stdc++.h>

using namespace std;

class Solution {
private:
  bool isVowel(char c){
    return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
  }
public:
  vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
    vector<int> res;
    vector<int> s(words.size());
    s[0] = isVowel(words[0][0]) && isVowel(words[0][words[0].length()-1]);
    for (int i = 1; i < words.size(); i++) s[i] = s[i-1] + (isVowel(words[i][0]) && isVowel(words[i][words[i].length()-1]));
    for (auto q: queries) {
      if(q[0]==0) res.push_back(s[q[1]]);
      else res.push_back(s[q[1]]-s[q[0]-1]);
    }
    return res;
  }
};