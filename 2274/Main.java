import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = Math.max(top - special[special.length - 1], special[0] - bottom);
        for (int i = 1; i < special.length; i++)
            res = Math.max(special[i] - special[i - 1] - 1, res);
        return res;
    }
}