class Main {
    public static void main(String[] args) {

    }

    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences)
            res = Math.max(res, sentence.split(" ").length);
        return res;
    }
}