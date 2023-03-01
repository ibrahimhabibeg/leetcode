import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isValid("({[]{}}({[(){(})]}))"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && ((stack.peek() == '{' && s.charAt(i) == '}')
                    || (stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '(' && s.charAt(i) == ')'))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}