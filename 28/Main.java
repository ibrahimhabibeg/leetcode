class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.strStr("leetcode", "leeto"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}