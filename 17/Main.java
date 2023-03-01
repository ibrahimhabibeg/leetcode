import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String> res = main.letterCombinations("23");
        for (String string : res) {
            System.out.println(string);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[][] defVals = { { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
                { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            return res;
        }
        int digit = digits.charAt(0) - '2';
        if (digits.length() == 1) {
            for (String s : defVals[digit]) {
                res.add(s);
            }
            ;
            return res;
        }
        List<String> combinations = letterCombinations(digits.substring(1));
        for (String letterToAdd : defVals[digit]) {
            for (String combination : combinations) {
                res.add(letterToAdd + combination);
            }
        }
        return res;
    }
}