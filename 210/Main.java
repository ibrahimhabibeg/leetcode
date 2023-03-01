import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    int[] topoSort;
    int i = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preMap = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++)
            preMap.add(new ArrayList<Integer>());
        for (int[] prerequisite : prerequisites)
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        int[] colors = new int[numCourses];
        topoSort = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (colors[i] == 0 && !DFS(i, colors, preMap))
                return new int[0];
        return topoSort;
    }

    private boolean DFS(int node, int[] colors, List<List<Integer>> preMap) {
        colors[node] = 1;
        for (Integer pre : preMap.get(node))
            if (colors[pre] == 1 || (colors[pre] == 0 && !DFS(pre, colors, preMap)))
                return false;
        colors[node] = 2;
        topoSort[i++] = node;
        return true;
    }
}