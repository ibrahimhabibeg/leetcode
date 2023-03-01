class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode looping = head;
        looping.next = new ListNode(2);
        looping = looping.next;
        looping.next = new ListNode(3);
        Main main = new Main();
        ListNode res = main.reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode x = head;
        ListNode y = x.next;
        ListNode z = y.next;
        x.next = null;
        while (y != null) {
            y.next = x;
            x = y;
            y = z;
            if (z != null) {
                z = z.next;
            }
        }
        return x;
    }
}