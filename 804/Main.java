import java.util.HashSet;

class Main {
  public static void main(String[] args) {

  }

  String[] tranformations = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
      "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

  public int uniqueMorseRepresentations(String[] words) {
    HashSet<String> set = new HashSet<String>();
    for (String s : words) {
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray())
        sb.append(tranformations[c - 'a']);
      set.add(sb.toString());
    }
    return set.size();
  }
}