import java.util.*;

class Main {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            List<String> parenthesisList = new ArrayList<String>();
            parenthesisList.add("");
            return parenthesisList;
        }
        List<String> parenthesisList = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            List<String> l1 = generateParenthesis(i);
            List<String> l2 = generateParenthesis(n - 1 - i);
            for (String s1 : l1) {
                for (String s2 : l2) {
                    parenthesisList.add("(" + s1 + ")" + s2);
                }
            }
        }
        return parenthesisList;
    }
}