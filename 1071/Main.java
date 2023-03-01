class Main {
    public static void main(String[] args) {

    }

    public String gcdOfStrings(String str1, String str2) {
        return ((str1 + str2).equals(str2 + str1)) ? str1.substring(0, gcd(str1.length(), str2.length())) : "";
    }

    private int gcd(int a, int b) {
        if (b > a) {
            int c = a;
            a = b;
            b = c;
        }
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
}