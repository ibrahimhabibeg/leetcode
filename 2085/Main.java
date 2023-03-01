import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String[] words1 = { "leetcode", "is", "amazing", "as", "is" };
        String[] words2 = { "amazing", "leetcode", "is" };
        Main main = new Main();
        System.out.println(main.countWords(words1, words2));
    }

    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for (String s : words1)
            map1.put(s, map1.getOrDefault(s, 0)+1);
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        for (String s : words2)
            map2.put(s, map2.getOrDefault(s, 0)+1);
        int ans = 0;
        for (String s : map1.keySet())
            if(map1.get(s)==1 && map2.getOrDefault(s,0)==1)
                ans++;
        return ans;
    }
}