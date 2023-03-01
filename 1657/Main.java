import java.util.*;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.closeStringsWithPQ(
                "jhg",
                "ghj"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (map1.containsKey(c1)) {
                map1.put(c1, map1.get(c1) + 1);
            } else {
                map1.put(c1, 1);
            }
            if (map2.containsKey(c2)) {
                map2.put(c2, map2.get(c2) + 1);
            } else {
                map2.put(c2, 1);
            }
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        Integer[] arr1 = map1.values().toArray(new Integer[0]);
        Integer[] arr2 = map2.values().toArray(new Integer[0]);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStringsWithPQ(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (map1.containsKey(c1)) {
                map1.put(c1, map1.get(c1) + 1);
            } else {
                map1.put(c1, 1);
            }
            if (map2.containsKey(c2)) {
                map2.put(c2, map2.get(c2) + 1);
            } else {
                map2.put(c2, 1);
            }
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
        map1.forEach((k, v) -> pq1.add(v));
        map2.forEach((k, v) -> pq2.add(v));
        while (!pq1.isEmpty()) {
            if (!pq1.poll().equals(pq2.poll())) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStringsCounting(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        int[] n1 = new int[26], n2 = new int[26], w1 = new int[26], w2 = new int[26];
        Arrays.fill(n1, 0);
        Arrays.fill(n2, 0);
        Arrays.fill(w1, 0);
        Arrays.fill(w2, 0);
        for (int i = 0; i < word1.length(); i++) {
            int c1 = word1.charAt(i) - 'a';
            int c2 = word2.charAt(i) - 'a';
            n1[c1]++;
            n2[c2]++;
            w1[c1]=1;
            w2[c2]=1;
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        for (int i = 0; i < 26; i++) {
            if(n1[i]!=n2[i] || w1[i]!=w2[i]){
                return false;
            }
        }
        return true;
    }

}