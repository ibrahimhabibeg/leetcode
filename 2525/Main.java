class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.categorizeBox(2909, 3968, 3272, 727));
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = ((long) length) * ((long) width) * ((long) height);
        boolean isBulcky = length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000;
        boolean isHeavy = mass >= 100;
        return isBulcky && isHeavy ? "Both" : isBulcky ? "Bulky" : isHeavy ? "Heavy" : "Neither";
    }
}