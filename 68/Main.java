import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        fullJustifyUtil(words, maxWidth, 0, ans);
        return ans;
    }

    private void fullJustifyUtil(String[] words, int maxWidth, int start, List<String> ans) {
        if (start == words.length)
            return;
        int i = start;
        int sum = words[i].length();
        while (i + 1 < words.length && maxWidth >= sum + words[i + 1].length() + i + 1 - start) {
            i++;
            sum += words[i].length();
        }
        StringBuilder sb = new StringBuilder();
        int totalSpaces = maxWidth - sum;
        int avgSpace = i == words.length - 1 || i == start ? 1 : totalSpaces / (i - start);
        int noWithExtraSpace = i == words.length - 1 || i == start ? 0 : totalSpaces % (i - start);
        for (int j = start; j < i; j++) {
            sb.append(words[j]);
            int space = noWithExtraSpace > 0 ? 1 + avgSpace : avgSpace;
            if (noWithExtraSpace > 0)
                noWithExtraSpace--;
            sb.append(" ".repeat(space));
        }
        sb.append(words[i]);
        if (maxWidth > sb.length()) {
            sb.append(" ".repeat(maxWidth - sb.length()));
        }
        ans.add(sb.toString());
        fullJustifyUtil(words, maxWidth, i + 1, ans);
    }
}