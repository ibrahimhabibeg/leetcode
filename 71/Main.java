import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.simplifyPath("/.../"));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int l = 1;
        int r = 1;
        while (r < path.length()) {
            while (r < path.length() && path.charAt(r) != '/') {
                r++;
            }
            String sub = path.substring(l, r);
            if (sub.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (l!=r && !sub.equals(".") && !sub.equals("..")) {
                stack.add(sub);
            }
            r++;
            l = r;
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        if(ans.equals("")){
            ans = "/";
        }
        return ans;
    }
}