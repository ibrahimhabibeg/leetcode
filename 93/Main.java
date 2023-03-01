import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String> ans = main.restoreIpAddresses("2552511135");
        ans.forEach((s) -> {
            System.out.println(s);
        });
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        restoreIpAddressesUtil(s, new StringBuilder(), 0, 4, ans);
        return ans;
    }

    private void restoreIpAddressesUtil(String s, StringBuilder sb, int start, int dots, List<String> ans) {
        if (dots == 0 && start >= s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            sb.append('.');
        }
        if (dots == 0 || start >= s.length())
            return;
        for (int length = 1; length <= 3; length++) {
            if (isValid(s, start, length)) {
                for (int i = 0; i < length; i++)
                    sb.append(s.charAt(start + i));
                sb.append('.');
                restoreIpAddressesUtil(s, sb, start + length, dots - 1, ans);
                for (int i = 0; i < length + 1; i++)
                    sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public boolean isValid(String s, int start, int length) {
        return start + length - 1 < s.length() && (length == 1 || s.charAt(start) - '0' != 0) && (length != 3
                || ((s.charAt(start) - '0') * 100 + (s.charAt(start + 1) - '0') * 10
                        + (s.charAt(start + 2) - '0')) <= 255);
    }
}