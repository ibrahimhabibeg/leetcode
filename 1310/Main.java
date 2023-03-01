class Main {
    public static void main(String[] args) {

    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] xors = new int[arr.length+1];
        xors[0] = 0;
        for (int i = 1; i < xors.length; i++)
            xors[i] = xors[i-1] ^ arr[i-1];
        for (int i = 0; i < ans.length; i++)
            ans[i] = xors[queries[i][1]+1] ^ xors[queries[i][0]];
        return ans;
    }
}