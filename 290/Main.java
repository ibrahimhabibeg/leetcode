import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        HashMap<Character, String> cMap = new HashMap<Character, String>();
        HashMap<String, Character> sMap = new HashMap<String, Character>();
        for (int i = 0; i < words.length; i++) {
            if ((cMap.containsKey(pattern.charAt(i)) && !cMap.get(pattern.charAt(i)).equals(words[i]))
                    || (sMap.containsKey(words[i]) && !sMap.get(words[i]).equals(pattern.charAt(i))))
                return false;
            else {
                cMap.put(pattern.charAt(i), words[i]);
                sMap.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }
}