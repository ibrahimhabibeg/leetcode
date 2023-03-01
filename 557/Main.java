class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverseWordsUsingCharArr("hi i Am  baymax."));
    }

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
            } else {
                builder.reverse();
                ans += builder.toString() + " ";
                builder = new StringBuilder();
            }
        }
        builder.reverse();
        ans += builder.toString();
        return ans;
    }

    public String reverseWordsUsingCharArr(String s) {
        int start = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverseString(arr, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(arr, start, s.length()-1);
        return new String(arr);
    }

    public void reverseString(char[] arr, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            char temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }
}