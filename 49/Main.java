import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

class Main{
    public static void main(String[] args) {
        Main main = new Main();
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = main.groupAnagramsWithHashTable2(arr);
        for (List<String> l1 : output) {
            System.out.print("["); 
            for (String n : l1) {
                System.out.print(n + ", "); 
            }
            System.out.print("]"); 
            System.out.println();
         } 
    }
    public List<List<String>> groupAnagramsWithHashTable2(String[] strs) {
        Hashtable<String, List<String>> hashtable = new Hashtable<String, List<String>>();
        for (String s : strs) {
            String countStr = createCountStr(s);
            if(!hashtable.containsKey(countStr)){
                hashtable.put(countStr, new ArrayList<String>());
            }
            hashtable.get(countStr).add(s);
        }
        return new ArrayList<List<String>>(hashtable.values());
    }
    public String createCountStr(String str){
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c-'a']++;
        }
        String ans = "";
        for (int i : count) {
            ans += "-"+String.valueOf(i);
        }
        return ans;
    }
    public List<List<String>> groupAnagramsWithHashTable(String[] strs) {
        Hashtable<String, List<String>> hashtable = new Hashtable<String, List<String>>();
        for (String s : strs) {
            char[] tempArr = s.toCharArray();
            Arrays.sort(tempArr);
            String sortedS = new String(tempArr);
            if(!hashtable.containsKey(sortedS)){
                hashtable.put(sortedS, new ArrayList<String>());
            }
            hashtable.get(sortedS).add(s);
        }
        return new ArrayList<List<String>>(hashtable.values());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        String[][] formatedStrings = new String[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            formatedStrings[i][0] = strs[i];
            formatedStrings[i][1] = sortString(strs[i]);
        }
        Arrays.sort(formatedStrings, Comparator.comparing((x)->x[1]));
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> anigramGroup = new ArrayList<String>();
        anigramGroup.add(formatedStrings[0][0]);
        for (int i = 1; i < formatedStrings.length; i++) {
            if(!formatedStrings[i][1].equals(formatedStrings[i-1][1])){
                res.add(anigramGroup);
                anigramGroup = new ArrayList<String>();
            }
            anigramGroup.add(formatedStrings[i][0]);
        }
        res.add(anigramGroup);
        return res;
    }
    public String sortString(String str) {
        char tempArray[] = str.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
