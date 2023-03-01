class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode looping = head;
        looping.next = new ListNode(2);
        looping = looping.next;
        looping.next = new ListNode(3);
        looping = looping.next;
        looping.next = new ListNode(4);
        looping = looping.next;
        looping.next = new ListNode(5);
        Main main = new Main();
        ListNode res = main.reverseBetween(head, 1, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode x = head;
        ListNode beforeFirst = head;
        for (int i = 1; i < left; i++) {
            x = x.next;
            if (i == 1) {
                continue;
            }
            beforeFirst = beforeFirst.next;
        }
        ListNode first = x;
        ListNode y = x.next;
        ListNode z = y.next;
        for (int j = 0; j < right - left; j++) {
            y.next = x;
            x = y;
            y = z;
            if (z != null) {
                z = z.next;
            }
        }
        first.next = y;
        if (left == 1) {
            return x;
        }
        beforeFirst.next = x;
        return head;
    }

}