class Main{
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {
        int sum = 0;
        Character pc = 'A';
        Character c = s.charAt(s.length()-1);
        for (int i = 0; i<s.length(); i++) {
            if(i!=0){
                pc = s.charAt(i-1);
            }
            c = s.charAt(i);
            if(pc=='I'&&c=='V'){
                sum+=3;
            }else if(pc=='I'&&c=='X'){
                sum+=8;
            }else if(pc=='X'&&c=='L'){
                sum+=30;
            }else if(pc=='X'&&c=='C'){
                sum+=80;
            }else if(pc=='C'&&c=='D'){
                sum+=300;
            }else if(pc=='C'&&c=='M'){
                sum+=800;
            }else if(c=='I'){
                sum+=1;
            }else if(c=='V'){
                sum+=5;
            }else if(c=='X'){
                sum+=10;
            }else if(c=='L'){
                sum+=50;
            }else if(c=='C'){
                sum+=100;
            }else if(c=='D'){
                sum+=500;
            }else{
                sum+=1000;
            }
        }
        return sum;
    }
}