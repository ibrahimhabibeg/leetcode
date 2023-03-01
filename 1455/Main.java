class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isPrefixOfWord("i love eating burger", "burg"));
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}