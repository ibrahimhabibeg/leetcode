class Main {
    public static void main(String[] args) {
        int[][] img1 = { {0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0} };
        int[][] img2 = { {0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,0} };
        Main main = new Main();
        System.out.println(main.largestOverlap(img1, img2));
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxCount = 0;
        for (int i = -img2.length; i < img2.length; i++) {
            for (int j = -img2.length; j < img2.length; j++) {
                maxCount = Math.max(maxCount, calcOverlapWithGivenShift(i, j, img1, img2));
            }
        }
        return maxCount;
    }

    public int calcOverlapWithGivenShift(int x, int y, int[][] img1, int[][] img2) {
        int count = 0;
        int n = img1.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if(r+x<0 || r+x>=n || c+y<0 || c+y>=n){
                    continue;
                }
                if (img1[r][c] + img2[r + x][c + y] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}