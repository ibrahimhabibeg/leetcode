import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>(),
                startMap = new HashMap<Integer, Integer>(),
                lengthMap = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!startMap.containsKey(nums[i]))
                startMap.put(nums[i], i);
            countMap.put(nums[i], 1 + countMap.getOrDefault(nums[i], 0));
            lengthMap.put(nums[i], i - startMap.get(nums[i]) + 1);
            if (i == 0)
                ans = nums[0];
            else if (countMap.get(nums[i]) > countMap.get(ans)
                    || (countMap.get(nums[i]) == countMap.get(ans) && lengthMap.get(nums[i]) < lengthMap.get(ans)))
                ans = nums[i];
        }
        return lengthMap.get(ans);
    }

    public int findShortestSubArray2(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>(),
                startMap = new HashMap<Integer, Integer>();
        int degree = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            startMap.putIfAbsent(nums[i], i);
            countMap.put(nums[i], 1 + countMap.getOrDefault(nums[i], 0));
            if (countMap.get(nums[i]) > degree) {
                degree = countMap.get(nums[i]);
                ans = i - startMap.get(nums[i]) + 1;
            } else if (countMap.get(nums[i]) == degree) {
                ans = Math.min(ans, i - startMap.get(nums[i]) + 1);
            }
        }
        return ans;
    }
}