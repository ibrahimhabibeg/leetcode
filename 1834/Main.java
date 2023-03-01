import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
        Main main = new Main();
        System.out.println(Arrays.toString(main.getOrder(tasks)));
    }

    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        int[][] orderedTasks = new int[tasks.length][2];
        for (int i = 0; i < tasks.length; i++) {
            orderedTasks[i][0] = tasks[i][0];
            orderedTasks[i][1] = i;
        }
        Arrays.sort(orderedTasks, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            if (tasks[a][1] == tasks[b][1])
                return a - b;
            return tasks[a][1] - tasks[b][1];
        });
        int noAdded = 0;
        int i = 0;
        int time = 1;
        while (noAdded < tasks.length) {
            if (pq.isEmpty() && time < orderedTasks[i][0])
                time = orderedTasks[i][0];
            while (i < tasks.length && orderedTasks[i][0] <= time) {
                pq.add(orderedTasks[i][1]);
                i++;
            }
            int taskMade = pq.poll();
            ans[noAdded] = taskMade;
            noAdded++;
            if(Integer.MAX_VALUE-tasks[taskMade][1]>=time)
                time += tasks[taskMade][1];
            else time = Integer.MAX_VALUE;
        }
        return ans;
    }
}