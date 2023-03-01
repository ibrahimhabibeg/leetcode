class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverse(1000000012));
    }

    public int reverse(int x) {
        String orignalInt = String.valueOf(x);
        String res = "";
        for (int i = orignalInt.length() - 1; i >= 0; i--) {
            if (orignalInt.charAt(i) == '0' && orignalInt.length() != 1 && res == "") {
                continue;
            }
            if (orignalInt.charAt(i) == '-') {
                res = '-' + res;
            } else {
                res = res + orignalInt.charAt(i);
            }
        }
        try {
            int finalInt = Integer.parseInt(res);
            return finalInt;
        } catch (Exception e) {
            return 0;
        }
    }
}