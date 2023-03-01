class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.sortString("aaaabbbbcccc"));
    }

    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        boolean movingRight = true;
        while (size > 0) {
            int i = movingRight ? 0 : count.length - 1;
            while (size > 0 && i < count.length && i >= 0) {
                if (count[i] > 0) {
                    sb.append((char) (i + 'a'));
                    count[i]--;
                    size--;
                }
                i += movingRight ? 1 : -1;
            }
            movingRight = !movingRight;
        }
        return sb.toString();
    }
}