class Main{
    public static void main(String[] args) {
        
    }
    public int numberOfSteps(int num) {
        return Integer.bitCount(num) + Integer.toBinaryString(num).length()-1;
    }
}