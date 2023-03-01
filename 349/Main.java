import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i : nums1)
            map.put(i, false);
        int size = 0;
        for (int i : nums2){
            if(map.containsKey(i) && !map.get(i)){
                map.put(i, true);
                size++;
            }
        }
        int[] ans = new int[size];
        int i = 0;
        for (Integer key : map.keySet()) {
            if(map.get(key)){
                ans[i] = key;
                i++;
            }
        }
        return ans;
    }
}