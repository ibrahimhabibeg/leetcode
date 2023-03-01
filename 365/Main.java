class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.pulvrizer(12, 8));
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }
        int s = Math.min(jug2Capacity, jug1Capacity);
        int l = Math.max(jug2Capacity, jug1Capacity);
        int gcf = pulvrizer(l, s);
        if (targetCapacity <= l && targetCapacity % gcf == 0) {
            return true;
        } else if ((targetCapacity - l) % gcf == 0) {
            return true;
        } else if ((targetCapacity - s) % gcf == 0) {
            return true;
        }
        return false;
    }

    public int pulvrizer(int x, int y) {
        while (y != 0) {
            int temp = x;
            x = y;
            y = temp % y;
        }
        return x;
    }
}