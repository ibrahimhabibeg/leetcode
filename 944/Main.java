class Main {
    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for (int c = 0; c < strs[0].length(); c++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(c) - 'a' < strs[i - 1].charAt(c) - 'a') {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}