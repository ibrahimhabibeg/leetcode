import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> eMap = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            int newVal = tMap.containsKey(c) ? tMap.get(c) + 1 : 1;
            tMap.put(c, newVal);
        }
        int l = 0;
        while (l < s.length() && !tMap.containsKey(s.charAt(l)))
            l++;
        if(l==s.length())
            return "";
        sMap.put(s.charAt(l), 1);
        int r = l + 1;
        int noAdditions = 1;
        while (r < s.length() && noAdditions < t.length()) {
            char c = s.charAt(r);
            if (tMap.containsKey(c)) {
                if (!sMap.containsKey(c) || sMap.get(c) < tMap.get(c)) {
                    int newVal = sMap.containsKey(c) ? sMap.get(c) + 1 : 1;
                    sMap.put(c, newVal);
                    noAdditions++;
                } else {
                    int newVal = eMap.containsKey(c) ? eMap.get(c) + 1 : 1;
                    eMap.put(c, newVal);
                }
            }
            r++;
        }
        if (noAdditions < t.length())
            return "";
        r--;
        int minSubL = l;
        int minSubR = r;
        while (l < s.length() && r < s.length()) {
            char toFind = s.charAt(l);
            l++;
            while (l < s.length() && !tMap.containsKey(s.charAt(l)))
                l++;
            if (eMap.containsKey(toFind) && eMap.get(toFind) > 0) {
                eMap.put(toFind, eMap.get(toFind) - 1);
            } else {
                r++;
                while (r < s.length() && s.charAt(r) != toFind) {
                    char c = s.charAt(r);
                    if (tMap.containsKey(c)) {
                        int newVal = eMap.containsKey(c) ? eMap.get(c) + 1 : 1;
                        eMap.put(c, newVal);
                    }
                    r++;
                }
            }
            if (r != s.length() && r - l < minSubR - minSubL) {
                minSubR = r;
                minSubL = l;
            }
        }
        return s.substring(minSubL, minSubR + 1);
    }
}