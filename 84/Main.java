import java.util.Stack;

class Main {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        Main main = new Main();
        System.out.println(main.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < left.length; i++) {
            int lastRemoved = i;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                lastRemoved = stack.pop();
            left[i] = lastRemoved == i ? i : left[lastRemoved];
            stack.push(i);
        }
        int[] right = new int[heights.length];
        stack = new Stack<Integer>();
        for (int i = right.length - 1; i >= 0; i--) {
            int lastRemoved = i;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                lastRemoved = stack.pop();
            right[i] = lastRemoved == i ? i : right[lastRemoved];
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) 
            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
        return res;
    }
}