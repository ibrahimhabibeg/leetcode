import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[] piles = { 5, 4, 9 };
        Main main = new Main();
        System.out.println(main.minStoneSum(piles, 2));
    }

    public int minStoneSum(int[] piles, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int pile : piles) {
            ans += pile;
            pq.add(pile);
        }
        int i = 0;
        while (pq.peek()!=1 && i<k) {
            int removed = pq.poll();
            ans -= removed / 2;
            pq.add(removed - (removed / 2));
            i++;
        }
        return (int) ans;
    }
}