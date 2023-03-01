class Main {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int r = gas.length - 1;
        int l = 0;
        int inTank = gas[r] - cost[r];
        while (r > l) {
            if (inTank >= 0) {
                inTank += gas[l] - cost[l];
                l++;
            } else {
                r--;
                inTank += gas[r] - cost[r];
            }
        }
        return inTank >= 0 ? r : -1;
    }
}