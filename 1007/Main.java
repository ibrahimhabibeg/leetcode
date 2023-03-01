class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] tops = { 2, 5, 2, 5, 5 };
        int[] bottoms = { 5, 2, 5, 2, 2 };
        System.out.println(main.minDominoRotations(tops, bottoms));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int val1 = tops[0];
        int val2 = bottoms[0];
        int noOfVal1AtTop = 1;
        int noOfVal2AtTop = 0;
        int noOfVal1AtBottom = 0;
        int noOfVal2AtBottom = 1;
        boolean isVal1Possible = true;
        boolean isVal2Possible = true;
        for (int i = 1; i < n; i++) {
            if (tops[i] != val1 && bottoms[i] != val1) {
                isVal1Possible = false;
            }
            if (tops[i] != val2 && bottoms[i] != val2) {
                isVal2Possible = false;
            }
            if (tops[i] == val1) {
                noOfVal1AtTop++;
            }
            if (bottoms[i] == val1) {
                noOfVal1AtBottom++;
            }
            if (tops[i] == val2) {
                noOfVal2AtTop++;
            }
            if (bottoms[i] == val2) {
                noOfVal2AtBottom++;
            }
        }
        int minForVal1 = Math.min(n - noOfVal1AtTop, n - noOfVal1AtBottom);
        int minForVal2 = Math.min(n - noOfVal2AtTop, n - noOfVal2AtBottom);
        if (!isVal1Possible && !isVal2Possible) {
            return -1;
        } else if (!isVal1Possible) {
            return minForVal2;
        } else if (!isVal2Possible) {
            return minForVal1;
        } else {
            return Math.min(minForVal1, minForVal2);
        }
    }
}