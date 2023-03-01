class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        while (i <= start.length()) {
            while (i < start.length() && start.charAt(i) == 'X')
                i++;
            char a = i != start.length() ? start.charAt(i) : 'a';
            while (j < start.length() && end.charAt(j) == 'X')
                j++;
            char b = j != start.length() ? end.charAt(j) : 'a';
            if (a != b || (a == 'R' && j < i) || (a == 'L' && j > i))
                return false;
            i++;
            j++;
        }
        return true;
    }
}