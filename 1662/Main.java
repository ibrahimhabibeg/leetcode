class Main {
    public static void main(String[] args) {

    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < Math.max(word1.length, word2.length); i++) {
            if (i < word1.length) {
                s1 += word1[i];
            }
            if (i < word2.length) {
                s2 += word2[i];
            }
        }
        return s1.equals(s2);
    }
}