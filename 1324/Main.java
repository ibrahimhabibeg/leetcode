import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String> outList = main.printVertically("CONTEST IS COMING");
        for (String s : outList) {
            System.out.println(s + "=");
        }
    }

    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        Boolean biggerThanAllLength = false;
        int i = 0;
        List<String> res = new ArrayList<String>();
        while (!biggerThanAllLength) {
            biggerThanAllLength = true;
            String verticalWord = "";
            for (String word : words) {
                if (i < word.length()) {
                    biggerThanAllLength = false;
                    verticalWord += word.charAt(i);
                } else {
                    verticalWord += " ";
                }
            }
            if (!biggerThanAllLength) {
                res.add(verticalWord.stripTrailing());
            }
            i++;
        }
        return res;
    }
}