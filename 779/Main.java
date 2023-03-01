class Main {
    public static void main(String[] args) {
        Main main = new Main();
        for (int i = 1; i <= 16; i++) {
            System.out.print(main.kthGrammar(5, i));
        }
    }

    public int kthGrammar(int n, int k) {
        int x = 0;
        while ((k >> 0 & 1) == 0) {
            k >>= 1;
            x++;
        }
        while (k > 0) {
            x += k & 1;
            k >>= 1;
        }
        return (x-1)%2;
    }
}