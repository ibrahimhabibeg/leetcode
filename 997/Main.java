import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {

    }

    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0)
            return 1;
        HashMap<Integer, Integer> trustedBy = new HashMap<Integer, Integer>();
        HashSet<Integer> trustsSomeone = new HashSet<Integer>();
        for (int[] edge : trust) {
            trustsSomeone.add(edge[0]);
            trustedBy.put(edge[1], 1 + trustedBy.getOrDefault(edge[1], 0));
        }
        for (Integer i : trustedBy.keySet())
            if (!trustsSomeone.contains(i) && trustedBy.get(i) == n - 1)
                return i;
        return -1;
    }
}