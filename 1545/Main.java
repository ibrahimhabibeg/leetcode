import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 1; i <= 10; i++) {
            System.out.println(main.getNthString(i));
        }
    }

    public char findKthBit(int n, int k) {
        return getNthString(n).charAt(k - 1);
    }

    public String getNthString(int n) {
        if (n == 1) {
            return "0";
        }
        //String lastString = getNthString(n - 1);
        //String lastStringInverted = get
        return getNthString(n - 1) + "1" + reverseAndInvert(getNthString(n - 1));
    }

    public String reverseAndInvert(String s) {
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == '1') {
                res.setCharAt(s.length() - 1 - i, '0');
            } else if (s.charAt(i) == '0') {
                res.setCharAt(s.length() - 1 - i, '1');
            }
            if (s.charAt(s.length() - 1 - i) == '1') {
                res.setCharAt(i, '0');
            } else if (s.charAt(s.length() - 1 - i) == '0') {
                res.setCharAt(i, '1');
            }
        }
        if (s.length() % 2 == 1) {
            if (s.charAt(s.length() / 2) == '1') {
                res.setCharAt(s.length() / 2, '0');
            } else if (s.charAt(s.length() / 2) == '0') {
                res.setCharAt(s.length() / 2, '1');
            }
        }
        return res.toString();
    }
}