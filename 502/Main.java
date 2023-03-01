import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] profits = { 1, 2, 3 };
        int[] capital = { 1, 2, 2 };
        System.out.println(main.findMaximizedCapital(3, 1, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] capitalProfit = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++)
            capitalProfit[i] = new int[] { capital[i], profits[i] };
        Arrays.sort(capitalProfit, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(
                (a, b) -> capitalProfit[b][1] - capitalProfit[a][1]);
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < capital.length && capitalProfit[j][0] <= w) {
                priorityQueue.add(j);
                j++;
            }
            if (priorityQueue.peek() == null)
                break;
            w += capitalProfit[priorityQueue.poll()][1];
        }
        return w;
    }

    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> capitalsPQ = new PriorityQueue<Integer>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> profitssPQ = new PriorityQueue<Integer>((a, b) -> profits[b] - profits[a]);
        for (int i = 0; i < capital.length; i++)
            capitalsPQ.add(i);
        for (int i = 0; i < k; i++) {
            while (!capitalsPQ.isEmpty() && capital[capitalsPQ.peek()] <= w)
                profitssPQ.add(capitalsPQ.poll());
            if (profitssPQ.isEmpty())
                break;
            w += profits[profitssPQ.poll()];
        }
        return w;
    }
}