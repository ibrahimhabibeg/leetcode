class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.checkIfPangram("sthequickbrownfoxjumpoverthelazydogaaaaabbbcc"));
    }

    public boolean checkIfPangram(String sentence) {
        int lettersSeen = 0;
        for (Character letter : sentence.toCharArray()) {
            int letterIndex = letter - 'a';
            int letterNum = 1 << letterIndex;
            lettersSeen |= letterNum;
        }
        return lettersSeen + 1 == 1 << 26;
    }
}