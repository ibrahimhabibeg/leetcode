
import java.util.*;

class Main{
    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2,10,3,1,5,8};
        int[] efficiency = {5,4,3,9,7,2};
        int k = 2;
        System.out.println(maxPerformance(n,speed,efficiency,k));
    }
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] members = new int[n][2];
        for (int i = 0; i < members.length; i++) {
            members[i][0] = speed[i];
            members[i][1] = efficiency[i];
        }
        Arrays.sort(members,(m1,m2)->m2[1]-m1[1]);
        System.out.println(Arrays.deepToString(members));
        // minHeap will contain the speed of the members
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        long maxPerformance = 0;
        long teamSpeed = 0;
        for (int i = 0; i < n; i++) {
            if(minHeap.size()==k){
                teamSpeed -= minHeap.poll();
            }
            minHeap.add(members[i][0]);
            teamSpeed += members[i][0];
            // Because members is sorted in decreasing efficiency, the current member has the least efficiency
            maxPerformance = Math.max(maxPerformance,teamSpeed*members[i][1]);
        }
        return (int) (maxPerformance%1000000007);
    }
}
