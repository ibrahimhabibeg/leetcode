class Main {
    public static void main(String[] args) {

    }

    public int minTimeToType(String word) {
        char prev = 'a';
        int ans = 0;
        for (char c : word.toCharArray()) {
            int sm = Math.min(c - 'a', prev - 'a');
            int lg = Math.max(c - 'a', prev - 'a');
            ans += 1 + Math.min(lg - sm, sm + 26 - lg);
            prev = c;
        }
        return ans;
    }
}