class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        long left = 0;
        long right = n;
        while (true) {
            long mid = (left + right) / 2;
            boolean isBad = isBadVersion((int)mid);
            if (!isBad && isBadVersion((int) mid + 1)) {
                return (int) mid + 1;
            } else if (!isBad) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    int bad = 1702766719;
    boolean isBadVersion(int version) {
        if(version>=bad){
            return true;
        }
        return false;
    };
}