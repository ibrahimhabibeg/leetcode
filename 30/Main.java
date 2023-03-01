import java.util.*;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] words = { "bb", "bb", "bb" };
        List<Integer> ans = main.findSubstring("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", words);
        ans.forEach((a) -> {
            System.out.println(a);
        });
    }

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        int wordLength = words[0].length();
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (wordMap.containsKey(words[i]))
                wordMap.put(words[i], wordMap.get(words[i]) + 1);
            else
                wordMap.put(words[i], 1);
        }
        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {
            HashMap<String, Integer> subMap = new HashMap<String, Integer>();
            Boolean isCorrect = true;
            for (int j = 0; j < words.length; j++) {
                String sub = s.substring(i + wordLength * j, i + wordLength * (j + 1));
                int newSizeInSubMap = subMap.containsKey(sub) ? subMap.get(sub) + 1 : 1;
                if (!wordMap.containsKey(sub) || newSizeInSubMap > wordMap.get(sub)) {
                    isCorrect = false;
                    break;
                }
                subMap.put(sub, newSizeInSubMap);
            }
            if (isCorrect) {
                ans.add(i);
            }
        }
        return ans;
    }
}