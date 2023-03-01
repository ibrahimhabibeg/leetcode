class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.intToRoman(1));
        System.out.println(main.intToRomanWithClass(1));
    }

    public String intToRoman(int num) {
        String res = "";
        while (num > 0) {
            String toAdd;
            int d;
            if (num >= 1000) {
                d = 1000;
                toAdd = "M";
            } else if (num >= 900) {
                d = 900;
                toAdd = "CM";
            } else if (num >= 500) {
                d = 500;
                toAdd = "D";
            } else if (num >= 400) {
                d = 400;
                toAdd = "CD";
            } else if (num >= 100) {
                d = 100;
                toAdd = "C";
            } else if (num >= 90) {
                d = 90;
                toAdd = "XC";
            } else if (num >= 50) {
                d = 50;
                toAdd = "L";
            } else if (num >= 40) {
                d = 40;
                toAdd = "XL";
            } else if (num >= 10) {
                d = 10;
                toAdd = "X";
            } else if (num >= 9) {
                d = 9;
                toAdd = "IX";
            } else if (num >= 5) {
                d = 5;
                toAdd = "V";
            } else if (num >= 4) {
                d = 4;
                toAdd = "IV";
            } else {
                d = 1;
                toAdd = "I";
            }
            for (int i = 0; i < num / d; i++) {
                res += toAdd;
            }
            num %= d;
        }
        return res;
    }

    public String intToRomanWithClass(int num) {
        String res = "";
        RomanSymbol[] romanSymbols = { new RomanSymbol(1000, "M"), new RomanSymbol(900, "CM"),
                new RomanSymbol(500, "D"), new RomanSymbol(400, "CD"), new RomanSymbol(100, "C"),
                new RomanSymbol(90, "XC"), new RomanSymbol(50, "L"), new RomanSymbol(40, "XL"),
                new RomanSymbol(10, "X"), new RomanSymbol(9, "IX"), new RomanSymbol(5, "V"),
                new RomanSymbol(4, "IV"), new RomanSymbol(1, "I") };
        while (num > 0) {
            String toAdd = "";
            int d = 1;
            for (RomanSymbol romanSymbol : romanSymbols) {
                if (num >= romanSymbol.val) {
                    d = romanSymbol.val;
                    toAdd = romanSymbol.symbol;
                    break;
                }
            }
            for (int i = 0; i < num / d; i++) {
                res += toAdd;
            }
            num %= d;
        }
        return res;
    }
}