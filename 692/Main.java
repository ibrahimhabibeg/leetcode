import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] words = { "is", "the", "the", "day", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        List<String> output = main.topKFrequent(words, 4);
        for (String string : output) {
            System.out.println(string);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // sort words
        Arrays.sort(words);
        // build a list of WordWithFrequency
        List<WordWithFrequency> wordWithFrequencies = new ArrayList<WordWithFrequency>();
        String currentWord = words[0];
        int currentFrequency = 0;
        for (String word : words) {
            if (word.equals(currentWord)) {
                currentFrequency++;
            } else {
                wordWithFrequencies.add(new WordWithFrequency(currentWord, currentFrequency));
                currentFrequency = 1;
                currentWord = word;
            }
        }
        wordWithFrequencies.add(new WordWithFrequency(currentWord, currentFrequency));
        // sort list by frequency and then lexographical order.
        Collections.sort(wordWithFrequencies, new Comparator<WordWithFrequency>() {
            @Override
            public int compare(WordWithFrequency a, WordWithFrequency b) {
                if (a.frequency > b.frequency || (a.frequency == b.frequency && a.word.compareTo(b.word) < 0)) {
                    return -1;
                }
                return 1;
            }
        });
        // return the first k of the list
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            res.add(wordWithFrequencies.get(i).word);
        }
        return res;
    }
}