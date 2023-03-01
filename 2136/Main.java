import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Integer> indicesSortedByGrow = new ArrayList<Integer>();
        for (int i = 0; i < growTime.length; i++) {
            indicesSortedByGrow.add(i);
        }
        Collections.sort(indicesSortedByGrow, Comparator.comparingInt((i) -> -growTime[i]));
        int plantingSum = 0;
        int ans = 0;
        for (int i = 0; i < growTime.length; i++) {
            int j = indicesSortedByGrow.get(i);
            plantingSum += plantTime[j];
            ans = Math.max(ans, plantingSum + growTime[j]);
        }
        return ans;
    }
}