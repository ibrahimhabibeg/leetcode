import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {

    }

    public int largestInteger(int num) {
        int numCopy = num;
        PriorityQueue<Integer> even = new PriorityQueue<Integer>(), odd = new PriorityQueue<Integer>();
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit % 2 == 0)
                even.add(lastDigit);
            else
                odd.add(lastDigit);
            num /= 10;
        }
        int res = 0, pow = 1;
        while (numCopy > 0) {
            int lastDigit = numCopy % 10;
            if (lastDigit % 2 == 0)
                res += pow * even.poll();
            else
                res += pow * odd.poll();
            pow *= 10;
            numCopy /= 10;
        }
        return res;
    }
}