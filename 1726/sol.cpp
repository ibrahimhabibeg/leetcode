class Solution {
public:
    int tupleSameProduct(vector<int>& a) {
        int n = a.size(), res = 0;
        map<int, int> mp;
        for(int i = 0; i < n; i++) for(int j = i+1; j < n; j++) mp[a[i]*a[j]]++;
        for(auto [v, c]: mp) res += 4*c*(c-1);
        return res;
    }
};
