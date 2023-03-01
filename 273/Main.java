class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("=" + main.numberToWords(1497894519) + "=");
    }

    String[] ones = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    String[] tensWith1First = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    String[] tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else if (num >= 1000000000) {
            if (num % 1000000000 > 0) {
                return numToWords3Digit(num / 1000000000) + " Billion " + numberToWords(num % 1000000000);
            }
            return numToWords3Digit(num / 1000000000) + " Billion";
        } else if (num >= 1000000) {
            if (num % 1000000 > 0) {
                return numToWords3Digit(num / 1000000) + " Million " + numberToWords(num % 1000000);
            }
            return numToWords3Digit(num / 1000000) + " Million";
        } else if (num >= 1000) {
            if (num % 1000 > 0) {
                return numToWords3Digit(num / 1000) + " Thousand " + numberToWords(num % 1000);
            }
            return numToWords3Digit(num / 1000) + " Thousand";
        } else {
            return numToWords3Digit(num);
        }
    }

    public String numToWords3Digit(int num) {
        // 1<= num <= 999
        if (num >= 100) {
            if (num % 100 > 0) {
                return ones[num / 100 - 1] + " Hundred " + numToWords3Digit(num % 100);
            }
            return ones[num / 100 - 1] + " Hundred";
        } else if (num >= 20) {
            if (num % 10 > 0) {
                return tens[num / 10 - 2] + " " + ones[num % 10 - 1];
            }
            return tens[num / 10 - 2];
        } else if (num >= 10) {
            return tensWith1First[num % 10];
        } else {
            return ones[num - 1];
        }
    }
}