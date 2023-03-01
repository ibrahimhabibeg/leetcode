class Main{
    public static void main(String[] args) {
        
    }
    public String longestCommonPrefix(String[] strs) {
        String p="";
        int i=0;
        while(true){
            if(strs[0].length()==i){
                return p;
            }
            Character c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length()==i || strs[j].charAt(i)!=c){
                    return p;
                }
            }
            p+=c;
            i++;
        }
    }
}