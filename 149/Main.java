import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        int[][] points = { { -6, -1 }, { 3, 1 }, { 12, 3 } };
        Main main = new Main();
        System.out.println(main.maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        if (points.length == 1)
            return 1;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<Integer, HashMap<Integer,Integer>>();
            int max = 0;
            for (int j = i+1; j < points.length; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                int gcd = getGCD(dy, dx);
                dy/=gcd;
                dx/=gcd;
                if(!map.containsKey(dy))
                    map.put(dy, new HashMap<Integer,Integer>());
                map.get(dy).put(dx, map.get(dy).getOrDefault(dx, 1)+1);
                max = Math.max(max, map.get(dy).get(dx));
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
    private int getGCD(int a, int b){
        if(b==0)
            return a;
        return getGCD(b, a%b);
    }
}