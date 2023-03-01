import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestValidParentheses("(()()(((()))())))((()()(()))(((())((())((()))((())((()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                res = Math.max(res, i-stack.peek());
            }
        }
        return res;
    }
}