import java.util.Arrays;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.halvesAreAlike("textbook"));
    }

    public boolean halvesAreAlike(String s) {
        HashSet<Character> vowels = new HashSet<Character>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int n1 = 0;
        int n2 = 0;
        int h = s.length() / 2;
        for (int i = 0; i < h; i++) {
            if (vowels.contains(s.charAt(h - 1 - i))) {
                n1++;
            }
            if (vowels.contains(s.charAt(h + i))) {
                n2++;
            }
        }
        return n1 == n2;
    }
}