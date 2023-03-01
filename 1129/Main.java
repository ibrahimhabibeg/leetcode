import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        int[][] redEdges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } }, blueEdges = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
        Main main = new Main();
        System.out.println(Arrays.toString(main.shortestAlternatingPaths(5, redEdges, blueEdges)));
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<Integer>> redMap = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, List<Integer>> blueMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            redMap.put(i, new ArrayList<Integer>());
            blueMap.put(i, new ArrayList<Integer>());
        }
        for (int[] rel : redEdges)
            redMap.get(rel[0]).add(rel[1]);
        for (int[] rel : blueEdges)
            blueMap.get(rel[0]).add(rel[1]);
        int[] res = BFS(n, redMap, blueMap, true);
        int[] blueRes = BFS(n, redMap, blueMap, false);
        for (int i = 0; i < n; i++)
            if (res[i] == -1 || (blueRes[i] != -1 && res[i] > blueRes[i]))
                res[i] = blueRes[i];
        return res;
    }

    private int[] BFS(int n, HashMap<Integer, List<Integer>> redMap, HashMap<Integer, List<Integer>> blueMap,
            boolean isRed) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        boolean[][] checked = new boolean[n][2];
        checked[0][isRed ? 0 : 1] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        res[0] = 0;
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            HashMap<Integer, List<Integer>> map = isRed ? redMap : blueMap;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (Integer connectedNode : map.get(node)) {
                    if (!checked[connectedNode][isRed ? 1 : 0]) {
                        queue.add(connectedNode);
                        checked[connectedNode][isRed ? 1 : 0] = true;
                    }
                    if (res[connectedNode] == -1)
                        res[connectedNode] = pathLength;
                }
            }
            isRed = !isRed;
        }
        return res;
    }

    public int[] shortestAlternatingPaths2(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<Integer>> redMap = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, List<Integer>> blueMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            redMap.put(i, new ArrayList<Integer>());
            blueMap.put(i, new ArrayList<Integer>());
        }
        for (int[] rel : redEdges)
            redMap.get(rel[0]).add(rel[1]);
        for (int[] rel : blueEdges)
            blueMap.get(rel[0]).add(rel[1]);
        int[][] BFS = new int[n][2];
        for (int i = 1; i < n; i++) {
            BFS[i][0] = -1;
            BFS[i][1] = -1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { 0, 0 });
        queue.add(new int[] { 0, 1 });
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int color = node[1], antiColor = node[1] == 0 ? 1 : 0;
            HashMap<Integer, List<Integer>> map = color == 0 ? redMap : blueMap;
            for (Integer connectedNode : map.get(node[0])) {
                if (BFS[connectedNode][antiColor] == -1) {
                    BFS[connectedNode][antiColor] = 1 + BFS[node[0]][color];
                    queue.add(new int[] { connectedNode, antiColor });
                }
            }
        }
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            if (BFS[i][1] == -1 || (BFS[i][0] != -1 && BFS[i][0] < BFS[i][1]))
                res[i] = BFS[i][0];
            else
                res[i] = BFS[i][1];
        }
        return res;
    }
}