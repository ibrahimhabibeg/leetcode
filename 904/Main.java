class Main {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        int l = 0, r = 1, farFruit = fruits[0], farFruitLoc = 0;
        while (r < fruits.length && fruits[r] == farFruit) {
            farFruitLoc = r;
            r++;
        }
        if (r == fruits.length)
            return fruits.length;
        int res = r - l + 1, nearFruit = fruits[r], nearFruitLoc = r;
        r++;
        while (r < fruits.length) {
            if (fruits[r] != nearFruit && fruits[r] != farFruit)
                l = farFruitLoc + 1;
            if (fruits[r] != nearFruit) {
                farFruit = nearFruit;
                farFruitLoc = nearFruitLoc;
                nearFruit = fruits[r];
            }
            nearFruitLoc = r;
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}