import java.util.Arrays;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] temp = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(main.dailyTemperatures(temp)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<Integer>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < res.length; i++) {
            while (!s.empty() && temperatures[s.peek()] < temperatures[i]) {
                int x = s.pop();
                res[x] = i - x;
            }
            s.push(i);
        }
        return res;
    }

    
}