class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(main.removeNthFromEndTwoPointer(head, 5).val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode x = head.next;
        while (x != null) {
            size++;
            x = x.next;
        }
        if (size - n == 0) {
            return head.next;
        }
        x = head;
        for (int i = 0; i < size - n - 1; i++) {
            x = x.next;
        }
        x.next = x.next.next;
        return head;
    }

    public ListNode removeNthFromEndTwoPointer(ListNode head, int n) {
        int size = 0;
        ListNode x = head;
        ListNode y = null;
        while (x != null) {
            x = x.next;
            size++;
            if (size == n + 1) {
                y = head;
            } else if (size > n + 1) {
                y = y.next;
            }
        }
        if(y==null){
            return head.next;
        }else{
            y.next = y.next.next;
            return head;
        }
    }
}