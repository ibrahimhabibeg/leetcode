class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        Main main = new Main();
        ListNode res = main.reverseKGroup(head, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode countingSize = head;
        while (countingSize != null) {
            countingSize = countingSize.next;
            n++;
        }
        if (n == 0 || n == 1 || k == 1) {
            return head;
        }
        ListNode previousGroupTail = null;
        ListNode currentHead = head;
        for (int i = 0; i < n / k; i++) {
            ListNode x = currentHead;
            ListNode y = x.next;
            ListNode z = y.next;
            for (int j = 0; j < k - 1; j++) {
                y.next = x;
                x = y;
                y = z;
                if (z != null) {
                    z = z.next;
                }
            }
            currentHead.next = y;
            if (i == 0) {
                head = x;
            } else {
                previousGroupTail.next = x;
            }
            previousGroupTail = currentHead;
            currentHead = currentHead.next;
        }
        return head;
    }
}