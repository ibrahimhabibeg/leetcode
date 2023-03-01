class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.countTime("14:56"));
    }

    public int countTime(String time) {
        int ans = 1;
        int second = time.charAt(1) - '0';
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            ans *= 24;
        } else if (time.charAt(0) == '?') {
            if (second >= 4 && second <= 9) {
                ans *= 2;
            } else {
                ans *= 3;
            }
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) == '2') {
                ans *= 4;
            } else {
                ans *= 10;
            }
        }
        if (time.charAt(3) == '?') {
            ans *= 6;
        }
        if (time.charAt(4) == '?') {
            ans *= 10;
        }
        return ans;
    }
}