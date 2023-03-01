class Main{
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.fastExponentiate(2,10));
    }
    public double myPow(double x, int n) {
        if(n==0 || x==1){
            return 1;
        }
        if(x==0){
            return 0;
        }
        double res = fastExponentiate(x,n);
        if(n<0){
            return 1/res;
        }
        return res;
    }
    public double fastExponentiate(double x, int n){
        double z = n;
        z = Math.abs(z);
        double y = 1;
        while(z>1){
            if(z%2==1){
                y*=x;
            }
            x*=x;
            z=Math.floor(z/2);
        }
        return x*y;
    }
}