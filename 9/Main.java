class Main{
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int n = num.length();
        for (int i = 0; i < n/2; i++) {
            if(num.charAt(i) != num.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindromeWithoutString(int x) {
        if(x<0){
            return false;
        }else if(x==0){
            return true;
        }
        int n = (int) (Math.log10(x))+1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = x%10;
            x = x/10;
        } 
        for (int i = 0; i < n/2; i++) {
            if(arr[i]!=arr[n-i-1]){
                return false;
            }
        }
        return true;
    }
}