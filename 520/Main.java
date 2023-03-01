class Main {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String word) {
        return allButFirstSmall(word) || allCapital(word);
    }

    private boolean allButFirstSmall(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean allCapital(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)))
                return false;
        }
        return true;
    }
}