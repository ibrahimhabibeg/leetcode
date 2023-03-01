class Main {
    public static void main(String[] args) {
        int[] nums1 = { 2, 4, 5, 8, 10 };
        int[] nums2 = { 4, 6, 8, 9 };
        Main main = new Main();
        System.out.println(main.maxSumDP(nums1, nums2));
    }

    public int maxSumDP(int[] nums1, int[] nums2) {
        long[] nums1Ans = new long[nums1.length];
        long[] nums2Ans = new long[nums2.length];
        long ans = Math.max(maxSumDPUtil(nums1, nums2, 0, 0, nums1Ans, nums2Ans),
                maxSumDPUtil(nums2, nums1, 0, 0, nums2Ans, nums1Ans));
        return (int) (ans % 1000000007);
    }

    private long maxSumDPUtil(int[] prim, int[] sec, int i, int j, long[] primAns, long[] secAns) {
        if (i >= prim.length)
            return 0;
        if (primAns[i] != 0)
            return primAns[i];
        while (j < sec.length && sec[j] < prim[i])
            j++;
        long ans = 0;
        if (j < sec.length && sec[j] == prim[i]) {
            ans = prim[i] + Math.max(maxSumDPUtil(prim, sec, i + 1, j + 1, primAns, secAns),
                    maxSumDPUtil(sec, prim, j + 1, i + 1, secAns, primAns));
            secAns[j] = ans;
        } else
            ans = prim[i] + maxSumDPUtil(prim, sec, i + 1, j, primAns, secAns);
        primAns[i] = ans;
        return ans;
    }

    public int maxSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                sum1 = nums1[i] + Math.max(sum1, sum2);
                sum2 = sum1;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else {
                sum2 += nums2[j];
                j++;
            }
        }
        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }
        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }
        return (int) (Math.max(sum1, sum2) % 1000000007);
    }
}