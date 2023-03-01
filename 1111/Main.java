class Main {
    public static void main(String[] args) {

    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(')
                depth++;
            ans[i] = depth % 2;
            if (seq.charAt(i) == ')')
                depth--;
        }
        return ans;
    }
}