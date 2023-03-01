import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        int[] tasks = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4, 5, 5 };
        Main main = new Main();
        System.out.println(main.minimumRounds(tasks));
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : tasks) {
            int c = map.containsKey(i) ? map.get(i) + 1 : 1;
            map.put(i, c);
        }
        int ans = 0;
        for (int i : map.values()) {
            if (i == 1)
                return -1;
            if (i % 3 == 0)
                ans += i / 3;
            else
                ans += (i / 3) + 1;
        }
        return ans;
    }
}