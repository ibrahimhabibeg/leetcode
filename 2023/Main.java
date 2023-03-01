import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (isConcatEqualToTarget(nums[i], nums[j], target))
                    res++;
            }
        }
        return res;
    }

    private boolean isConcatEqualToTarget(String s1, String s2, String target) {
        if (s1.length() + s2.length() != target.length())
            return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != target.charAt(i))
                return false;
        for (int i = 0; i < s2.length(); i++)
            if (s2.charAt(i) != target.charAt(s1.length() + i))
                return false;
        return true;
    }

    public int numOfPairs2(String[] nums, String target) {
        int res = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String num : nums)
            map.put(num, 1 + map.getOrDefault(num, 0));
        for (String num : map.keySet()) {
            if (isPrefix(num, target)) {
                String suffix = neededSuffix(num, target);
                res += map.get(num) * map.getOrDefault(suffix, 0);
                if (suffix.equals(num))
                    res -= map.get(num);
            }
        }
        return res;

    }

    private boolean isPrefix(String s, String target) {
        if (s.length() > target.length())
            return false;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != target.charAt(i))
                return false;
        return true;
    }

    private String neededSuffix(String s, String target) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < target.length(); i++)
            sb.append(target.charAt(i));
        return sb.toString();
    }
}