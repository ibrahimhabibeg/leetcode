import java.util.Stack;

class Main {
    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 5, 4, 3, 2, 1 };
        Main main = new Main();
        System.out.println(main.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedIndex = 0;
        int poppedIndex = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (poppedIndex < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            } else if (pushedIndex >= pushed.length) {
                return false;
            } else {
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            }
        }
        return true;
    }
}