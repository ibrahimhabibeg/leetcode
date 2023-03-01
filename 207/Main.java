import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        System.out.println(main.canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preMap = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++)
            preMap.add(new ArrayList<Integer>());
        for (int[] prerequisite : prerequisites)
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (colors[i] == 0 && !DFS(i, colors, preMap))
                return false;
        return true;
    }

    private boolean DFS(int node, int[] colors, List<List<Integer>> preMap) {
        colors[node] = 1;
        for (Integer pre : preMap.get(node))
            if (colors[pre] == 1 || (colors[pre] == 0 && !DFS(pre, colors, preMap)))
                return false;
        colors[node] = 2;
        return true;
    }
}