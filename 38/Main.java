class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int m = 20;
        System.out.println(main.countAndSay(m));
        System.out.println(main.countAndSayOg(m));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        String res = "";
        int count = 0;
        Character num = s.charAt(0);
        for (Character c : s.toCharArray()) {
            if (num == c) {
                count++;
                continue;
            }
            res = res + count + num;
            count = 1;
            num = c;
        }
        res = res + count + num;
        return res;
    }

    public String countAndSayOg(int n) {
        if (n == 1) {
            return "1";
        }
        String toSay = countAndSay(n - 1);
        String res = "";
        int count = 1;
        Character num = toSay.charAt(0);
        for (int i = 1; i < toSay.length(); i++) {
            if (toSay.charAt(i) == num) {
                count++;
            } else {
                res = res.concat(Integer.toString(count)) + num;
                count = 1;
                num = toSay.charAt(i);
            }
        }
        res = res.concat(Integer.toString(count)) + num;
        return res;
    }
}