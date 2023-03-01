class Main {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode x = head;
        ListNode tail = null;
        int n = 0;
        while (x != null) {
            n++;
            tail = x;
            x = x.next;
        }
        if(n==0||n==1) return head;
        k = k % n;
        if(k==0) return head;
        x = head;
        for (int i = 0; i < n - k - 1; i++) {
            x = x.next;
        }
        ListNode newHead = x.next;
        x.next = null;
        tail.next = head;
        return newHead;
    }
}