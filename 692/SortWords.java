import java.util.Comparator;

class SortWords implements Comparator<WordWithFrequency> {
  public int compare(WordWithFrequency a, WordWithFrequency b){
    if(a.frequency>b.frequency || (a.frequency==b.frequency && a.word.compareTo(b.word)<0)){
      return -1;
    }
    return 1;
  }
}
