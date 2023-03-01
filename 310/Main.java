import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Main {
    public static void main(String[] args) {
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 }, { 5, 6 }, { 6, 7 } };
        Main main = new Main();
        System.out.println(main.findMinHeightTrees(8, edges).get(0));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            if (adj.get(i).size() == 1)
                leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (Integer leaf : leaves) {
                int adjNode = adj.get(leaf).iterator().next();
                adj.get(adjNode).remove(leaf);
                if (adj.get(adjNode).size() == 1)
                    newLeaves.add(adjNode);
            }
            leaves = newLeaves;
        }
        if (leaves.size() == 0)
            leaves.add(0);
        return leaves;
    }
}