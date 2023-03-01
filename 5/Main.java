class Main{
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestPalindrome("cbbd"));
    }
    public String longestPalindrome(String s) {
        String sub = Character.toString(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            String currentSub = s.substring(i, i+1);
            int start = i-1;
            int end = i+1;
            while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                currentSub = s.substring(start, end+1);
                start--;
                end++;
            }
            if(currentSub.length()>sub.length()){
                sub = currentSub;
            }
            if(s.charAt(i)==s.charAt(i-1)){
                currentSub = s.substring(i-1, i+1);
                start = i-2;
                end = i+1;
                while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
                    currentSub = s.substring(start, end+1);
                    start--;
                    end++;
                }
                if(currentSub.length()>sub.length()){
                    sub = currentSub;
                }
            }
        }
        return sub;
    }
}