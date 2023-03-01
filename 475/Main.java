import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0, res = 0;
        for (int house : houses) {
            while (j < heaters.length && house > heaters[j])
                j++;
            if (j == 0)
                res = Math.max(res, heaters[j] - house);
            else if (j == heaters.length)
                res = Math.max(res, house - heaters[j - 1]);
            else
                res = Math.max(res, Math.min(heaters[j] - house, house - heaters[j - 1]));
        }
        return res;
    }
}