import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        String[] names = { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece", "onepiece(0)(8)",
                "onepiece(-4)", "onepiece(0)", "onepiece(0)", "onepiece(0)", "onepiece(0)", "onepiece(0)",
                "onepiece(0)", "onepiece(0)", "onepiece(0)", "onepiece(0)", "onepiece(0)", "onepiece(0)" };
        Main main = new Main();
        System.out.println(Arrays.toString(main.getFolderNames(names)));
    }
    ///////////////////////////////////////////////////////////////////
    //////////////////    WRONG   ///////////////////////////////////// 
    ///////////////////////////////////////////////////////////////////
    public String[] getFolderNames(String[] names) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int j = 1;
            while (set.contains(name)) {
                int num = getNumberInName(name);
                if (num > 0) {
                    name = name.substring(0, name.lastIndexOf('(') + 1) + j + ')';
                } else {
                    name = name + '(' + j + ')';
                }
                j++;
            }
            names[i] = name;
            set.add(name);
        }
        return names;
    }

    public int getNumberInName(String name) {
        int ans = -1;
        int startBracketIndex = name.lastIndexOf("(");
        if (name.charAt(name.length() - 1) == ')' && startBracketIndex > -1) {
            String inBrackets = name.substring(startBracketIndex + 1, name.length() - 1);
            try {
                int noInBrackets = Integer.parseInt(inBrackets);
                if (noInBrackets > 0)
                    ans = noInBrackets;
            } catch (Exception e) {
            }
        }
        return ans;
    }
}