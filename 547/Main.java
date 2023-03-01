class Main {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] isDiscovered = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!isDiscovered[i]) {
                res++;
                DFS(i, isConnected, isDiscovered);
            }
        }
        return res;
    }

    private void DFS(int i, int[][] isConnected, boolean[] isDiscovered) {
        isDiscovered[i] = true;
        for (int j = 0; j < isConnected.length; j++)
            if (isConnected[i][j] == 1 && !isDiscovered[j])
                DFS(j, isConnected, isDiscovered);
    }
}