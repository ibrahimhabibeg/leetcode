class Main{
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pw##kK 43 t$%^^dfgg1!"));
    }
    public static int lengthOfLongestSubstring(String s) {
        String sub = "";
        int maxL = 0;
        int curL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = sub.indexOf(c);
            if(j==-1){
                curL++;
                sub+=c;
            }else{
                curL = curL-j;
                sub = sub.substring(j+1)+c;
            }
            maxL=Math.max(maxL, curL);
        }
        return maxL;
    }
}