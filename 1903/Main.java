class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.largestOddNumber("4206"));
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}