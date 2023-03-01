import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        Main main = new Main();
        System.out.println(main.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        int n1, n2;
        Stack<Integer> s = new Stack<Integer>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    s.add(s.pop() + s.pop());
                    break;
                case "-":
                    n2 = s.pop();
                    n1 = s.pop();
                    s.add(n1 - n2);
                    break;
                case "*":
                    s.add(s.pop() * s.pop());
                    break;
                case "/":
                    n2 = s.pop();
                    n1 = s.pop();
                    s.add(n1 / n2);
                    break;
                default:
                    s.add(Integer.parseInt(token));
                    break;
            }
        }
        return s.peek();
    }
}