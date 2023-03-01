class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c == 1) {
            int s1 = i >= 0 ? a.charAt(i) - '0' : 0, s2 = j >= 0 ? b.charAt(j) - '0' : 0;
            res.insert(0, (s1 + s2 + c) % 2);
            c = (s1 + s2 + c) / 2;
            i--;
            j--;
        }
        return res.toString();
    }

}