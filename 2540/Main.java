import java.util.HashSet;

class Main {
    public static void main(String[] args) {

    }

    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums1)
            set.add(i);
        int res = -1;
        for (int i : nums2)
            if (set.contains(i))
                res = res == -1 ? i : Math.min(i, res);
        return res;
    }
    public int getCommon2(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i<nums1.length && j <nums2.length) {
            if(nums1[i]==nums2[j])
                return nums1[i];
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }
        return -1;
    }
}