import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 2 };
        int[] arr = { 3, 1, 2, 2 };
        Main main = new Main();
        System.out.println(main.canBeEqual(target, arr));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}