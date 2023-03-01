class Main{
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int noRows = 1;
        System.out.println(convert(str,noRows));
    }
    public static String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        StringBuilder sb  = new StringBuilder();
        int maxSkip = 2*numRows-2;
        for (int r = 0; r < numRows; r++) {
            int i = r;
            boolean firstTime = true;
            while(i<s.length()){
                sb.append(s.charAt(i));
                if(r==0 || r==numRows-1){
                    i+=maxSkip;
                }else if(firstTime){
                    i+=maxSkip-2*r;
                    firstTime = false;
                }else{
                    i+=2*r;
                    firstTime = true;
                }
            }
        }
        return sb.toString();
    }
}