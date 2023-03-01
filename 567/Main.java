class Main {
    public static void main(String[] args) {
        String s1 = "trinitrophenylmethylnitramine";
        String s2 = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        Main main = new Main();
        System.out.println(main.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] word = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            word[s1.charAt(i) - 'a']--;
            word[s2.charAt(i) - 'a']++;
        }
        if(allZero(word))
            return true;
        int i = 0, j = s1.length();
        while (j < s2.length()) {
            word[s2.charAt(i++) - 'a']--;
            word[s2.charAt(j++) - 'a']++;
            if (allZero(word))
                return true;
        }
        return false;
    }
    private boolean allZero(int[] word){
        for (int i : word)
            if(i!=0)
                return false;
        return true;
    }
}