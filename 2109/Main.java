class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] spaces = { 0, 1, 2, 3, 4, 5, 6 };
        System.out.println(main.addSpaces("spacing", spaces));
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int i = spaces.length-1;
        for (int j = s.length()-1; j >= 0; j--) {
            res.append(s.charAt(j));
            if(i>=0 && j==spaces[i]){
                res.append(' ');
                i--;
            }
        }
        return res.reverse().toString();
    }
}