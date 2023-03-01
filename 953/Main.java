class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] words = { "hello", "leetcode" };
        System.out.println(main.isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabet = new int[26];
        for (int i = 0; i < order.length(); i++)
            alphabet[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if(!isSmaller(alphabet, words[i-1], words[i]))
                return false;
        return true;
    }

    private boolean isSmaller(int[] alphabet, String word1, String word2) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (alphabet[word1.charAt(i) - 'a'] < alphabet[word2.charAt(i) - 'a'])
                return true;
            if (alphabet[word1.charAt(i) - 'a'] > alphabet[word2.charAt(i) - 'a'])
                return false;
        }
        return word1.length() <= word2.length() ? true : false;
    }
}