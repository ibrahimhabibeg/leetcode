class Main {
    public static void main(String[] args) {
        int[][] customers = { { 5, 2 } };
        Main main = new Main();
        System.out.println(main.averageWaitingTime(customers));
    }

    public double averageWaitingTime(int[][] customers) {
        long finishTime = 0;
        double sumWaiting = 0;
        for (int[] customer : customers) {
            finishTime = Math.max(finishTime, customer[0]) + customer[1];
            sumWaiting += finishTime - customer[0];
        }
        return sumWaiting / customers.length;
    }
}