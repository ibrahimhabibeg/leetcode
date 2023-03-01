class Main{
  public static void main(String[] args) {
    Main main = new Main();
    int[] arr1 = {1,2,3,4,5};
    int[] arr2 = {6,7,8,9,10,11,12,13,14,15};
    System.out.println(main.findMedianSortedArrays(arr1, arr2));
  }
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length+nums2.length;
    if(n%2==1){
      return getISmallest(nums1, 0, nums2, 0, (n+1)/2);
    }else{
      return (getISmallest(nums1, 0, nums2, 0, n/2)+ getISmallest(nums1, 0, nums2, 0, 1+n/2))/2;
    }
  }
  public double getISmallest(int[] nums1, int start1, int[] nums2, int start2, int i){
    if(start1>=nums1.length){
      return nums2[start2+i-1];
    }
    if(start2>=nums2.length){
      return nums1[start1+i-1];
    }
    if(i==1){
      return Math.min(nums1[start1], nums2[start2]);
    }
    int m1 = start1+i/2-1;
    int mVal1 = Integer.MAX_VALUE;
    if(m1<nums1.length){
      mVal1 = nums1[m1];
    }
    int m2 = start2+i/2-1;
    int mVal2 = Integer.MAX_VALUE;
    if(m2<nums2.length){
      mVal2 = nums2[m2];
    }
    if(mVal1<mVal2){
      return getISmallest(nums1, m1+1, nums2, start2, i-i/2);
    }else{
      return getISmallest(nums1, start1, nums2, m2+1, i-i/2);
    }
  }
}