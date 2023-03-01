class Main {
    public static void main(String[] args) {

    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0, a = startPos[0], b = startPos[1], c = homePos[0], d = homePos[1];
        while (a!=c) {
            a+=a<c?1:-1;
            ans+=rowCosts[a];
        }
        while (b!=d) {
            b+=b<d?1:-1;
            ans+=colCosts[b];
        }
        return ans;
    }
}