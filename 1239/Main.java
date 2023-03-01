import java.util.*;

class Main{
  public static void main(String[] args) {
    
  }
  public int maxLength(List<String> arr) {
    // mark strings containing duplicates
    Boolean[] containsDuplicates = new Boolean[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      String s = arr.get(i);
      Set<Character> set  = new HashSet<Character>();
      for (char c : s.toCharArray()) {
        if(!set.add(c)){
          containsDuplicates[i] = true;
          break;
        }
      }
    }
    int res = 0;
    for (int i = 0; i < arr.size(); i++) {
      String s = arr.get(i);
      Set<Character> set  = new HashSet<Character>();
      Boolean sContainsDuplicates = false;
      for (char c : s.toCharArray()) {
        if(!set.add(c)){
          sContainsDuplicates = true;
          break;
        }
      }
      if(!sContainsDuplicates){
        for (int j = 0; j < arr.size(); j++) {
          if(j==i){
            continue;
          }
          Boolean thereIsCharDuplicate = false;
          for (Character c : arr.get(j).toCharArray()) {
            if (set.contains(c)) {
              thereIsCharDuplicate = true;
              break;
            }
          }
        }
      }
    }
    
    return res;    
  }
}