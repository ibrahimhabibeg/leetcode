import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] roads = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        System.out.println(main.minimumFuelCost(roads, 5));
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<Integer>());
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        boolean[] checked = new boolean[n];
        int[] sizes = new int[n];
        return DFS(map, checked, sizes, 0, seats);
    }

    private long DFS(HashMap<Integer, List<Integer>> graph, boolean[] checked, int[] sizes, int node, int seats) {
        long fuelToReach = 0;
        sizes[node] = 1;
        checked[node] = true;
        for (Integer adjNode : graph.get(node)) {
            if (!checked[adjNode]) {
                long fuelToReachAdj = DFS(graph, checked, sizes, adjNode, seats);
                sizes[node] += sizes[adjNode];
                fuelToReach += fuelToReachAdj + (sizes[adjNode] + seats - 1) / seats;
            }
        }
        return fuelToReach;
    }

    public long minimumFuelCost2(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[] sizes = new int[n];
        return DFS2(graph, sizes, 0, 0, seats);
    }

    private long DFS2(List<List<Integer>> graph, int[] sizes, int node, int prev, int seats) {
        long fuelToReach = 0;
        sizes[node] = 1;
        for (Integer adj : graph.get(node)) {
            if (adj != prev) {
                long fuelToReachAdj = DFS2(graph, sizes, adj, node, seats);
                sizes[node] += sizes[adj];
                fuelToReach += fuelToReachAdj + (sizes[adj] + seats - 1) / seats;
            }
        }
        return fuelToReach;
    }

}