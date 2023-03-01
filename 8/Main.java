class Main {
  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.myAtoi("  -2147483658 gsdfgds"));
  }

  public int myAtoi(String s) {
    int sign = 1;
    int i = 0;
    int num = 0;
    while (i < s.length() && s.charAt(i) == ' ') {
      i++;
    }
    if (i == s.length()) {
      return 0;
    }
    if (s.charAt(i) == '-' || s.charAt(i) == '+') {
      if (s.charAt(i) == '-') {
        sign = -1;
      }
      i++;
    }
    while (i < s.length()) {
      int newDigit = s.charAt(i) - '0';
      if (newDigit > 9 || newDigit < 0) {
        break;
      }
      if (sign == 1 && (Integer.MAX_VALUE / 10 < num
          || (Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < newDigit))) {
        return Integer.MAX_VALUE;
      }
      if (sign == -1 && (Integer.MAX_VALUE / 10 < num
          || (Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 + 1 < newDigit))) {
        return Integer.MIN_VALUE;
      }
      num = 10 * num + newDigit;
      i++;
    }
    return num * sign;
  }
}