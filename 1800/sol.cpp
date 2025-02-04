class Solution {
public:
    int maxAscendingSum(vector<int>& a) {
        int res = a[0], sum = a[0];
        for(int i = 1; i < a.size(); i++) {
            if(a[i]>a[i-1]) sum += a[i];
            else sum = a[i];
            res= max(res, sum);
        }
        return res;
    }
};