import java.util.HashMap;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.frequencySort("S4sd7854sfsRmkljEWBnDEGEVvVSGHDE78974fsYHEvGfETVXH488fgINGdsfs"));
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<Character>(map.size(), (a, b) -> map.get(b) - map.get(a));
        map.forEach((k, v) -> {
            pq.add(k);
        });
        StringBuilder ans = new StringBuilder();
        while (pq.isEmpty() != true) {
            Character c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}