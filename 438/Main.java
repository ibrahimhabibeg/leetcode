import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (p.length() > s.length())
            return res;
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            window[p.charAt(i) - 'a']--;
            window[s.charAt(i) - 'a']++;
        }
        if (allZero(window))
            res.add(0);
        int i = 0, j = p.length();
        while (j < s.length()) {
            window[s.charAt(i++) - 'a']--;
            window[s.charAt(j++) - 'a']++;
            if (allZero(window))
                res.add(i);
        }
        return res;
    }

    private boolean allZero(int[] window) {
        for (int i : window)
            if (i != 0)
                return false;
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (p.length() > s.length())
            return res;
        int[] window = new int[26];
        int noNotZero = 0;
        for (int i = 0; i < p.length(); i++) {
            if(window[p.charAt(i) - 'a']==0)
                noNotZero++;
            else if(window[p.charAt(i) - 'a']==1)
                noNotZero--;
            window[p.charAt(i) - 'a']--;
            if(window[s.charAt(i) - 'a']==0)
                noNotZero++;
            else if(window[s.charAt(i) - 'a']==-1)
                noNotZero--;
            window[s.charAt(i) - 'a']++;
        }
        if (noNotZero==0)
            res.add(0);
        int i = 0, j = p.length();
        while (j < s.length()) {
            if(window[s.charAt(i) - 'a']==0)
                noNotZero++;
            else if(window[s.charAt(i) - 'a']==1)
                noNotZero--;
            window[s.charAt(i++) - 'a']--;
            if(window[s.charAt(j) - 'a']==0)
                noNotZero++;
            else if(window[s.charAt(j) - 'a']==-1)
                noNotZero--;
            window[s.charAt(j++) - 'a']++;
            if (noNotZero==0)
                res.add(i);
        }
        return res;
    }
}