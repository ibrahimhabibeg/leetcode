class Main {
    public static void main(String[] args) {
        ListNode head = null;
        Main main = new Main();
        ListNode res = main.oddEvenList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode lOdd = head;
        ListNode lEven = lOdd != null ? lOdd.next : null;
        ListNode cOdd = lEven != null ? lEven.next : null;
        ListNode nEven = cOdd != null ? cOdd.next : null;
        while (cOdd != null) {
            lEven.next = nEven;
            cOdd.next = lOdd.next;
            lOdd.next = cOdd;

            lOdd = cOdd;
            cOdd = nEven != null ? nEven.next : null;
            lEven = nEven;
            nEven = cOdd != null ? cOdd.next : null;
        }
        return head;
    }
}