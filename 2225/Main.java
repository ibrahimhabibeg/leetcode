import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 },
                { 10, 9 } };
        Main main = new Main();
        List<List<Integer>> res = main.findWinners(matches);
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.put(match[1], 1 + map.getOrDefault(match[1], 0));
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0)
                res.get(0).add(key);
            else if (map.get(key) == 1)
                res.get(1).add(key);
        }
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}