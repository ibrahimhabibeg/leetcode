class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.divide(-1010369383, -2147483648));
    }

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        long res = 0;
        int sign = divisor < 0 ^ dividend < 0?-1:1;
        long absDivisor = Math.abs(divisor);
        long absDividend = Math.abs(dividend);
        if(dividend==Integer.MIN_VALUE){
            absDividend = Integer.MAX_VALUE;
            absDividend++;
        }
        if(divisor==Integer.MIN_VALUE){
            absDivisor = Integer.MAX_VALUE;
            absDivisor++;
        }
        while (absDividend >= absDivisor) {
            long maxDivisor = absDivisor;
            long q = 1;
            while (absDividend>= maxDivisor<<1) {
                maxDivisor <<= 1;
                q <<= 1;
            }
            absDividend -= maxDivisor; 
            res += q;
        }
        return (int) res * sign;
    }
}