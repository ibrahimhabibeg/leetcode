import java.util.*;

class Main {
    public static void main(String[] args) {

    }

    public int compress(char[] chars) {
        int i = 0, count = 1;
        char val = chars[0];
        for (int j = 1; j < chars.length; j++) {
            if (chars[j] == val) {
                count++;
            } else {
                i = add(chars, i, val, count);
                val = chars[j];
                count = 1;
            }
        }
        return add(chars, i, val, count);
    }

    private int add(char[] chars, int i, char c, int count) {
        chars[i++] = c;
        if (count != 1) {
            String countStr = Integer.toString(count);
            for (int j = 0; j < countStr.length(); j++)
                chars[i++] = countStr.charAt(j);
        }
        return i;
    }
}