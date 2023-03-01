import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {2};
        Main main = new Main();
        main.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}