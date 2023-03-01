class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.multiply("102", "120"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String ans = "";
        String OGpow = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            String pow = OGpow;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                String s = (n1 * n2) + pow;
                ans = add(ans, s);
                pow = pow + '0';
            }
            OGpow = OGpow + '0';
        }
        return ans;
    }

    public String add(String num1, String num2) {
        String ans = "";
        int c = 0;
        int i = 1;
        while (i <= Math.min(num1.length(), num2.length())) {
            int s1 = num1.charAt(num1.length() - i) - '0';
            int s2 = num2.charAt(num2.length() - i) - '0';
            ans = (char) ((s1 + s2 + c) % 10 + '0') + ans;
            c = (s1 + s2 + c) / 10;
            i++;
        }
        while (i <= num1.length()) {
            int s = num1.charAt(num1.length() - i) - '0';
            ans = (char) ((s + c) % 10 + '0') + ans;
            c = (s) / 10;
            i++;
        }
        while (i <= num2.length()) {
            int s = num2.charAt(num2.length() - i) - '0';
            ans = (char) ((s + c) % 10 + '0') + ans;
            c = (s) / 10;
            i++;
        }
        if (c != 0)
            ans = (char) (c + '0') + ans;
        return ans;
    }
}