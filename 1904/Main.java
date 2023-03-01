class Main {
    public static void main(String[] args) {

    }

    public int numberOfRounds(String loginTime, String logoutTime) {
        int sH = (loginTime.charAt(0) - '0') * 10 + (loginTime.charAt(1) - '0');
        int eH = (logoutTime.charAt(0) - '0') * 10 + (logoutTime.charAt(1) - '0');
        int sM = (loginTime.charAt(3) - '0') * 10 + (loginTime.charAt(4) - '0');
        int eM = (logoutTime.charAt(3) - '0') * 10 + (logoutTime.charAt(4) - '0');
        if (eH == sH && eM >= sM)
            return Math.max(0, eM / 15 - (int) (Math.ceil(sM / 15.0)));
        if (eH < sH || (eH == sH && eM < sM))
            eH += 24;
        return 4 - (int) (Math.ceil(sM / 15.0)) + eM / 15 + 4 * (eH - sH - 1);
    }
}