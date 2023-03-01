class Main {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode x = head != null ? head.next : null;
        while (x != null && x.val == head.val) {
            while (x != null && x.val == head.val)
                x = x.next;
            head = x;
            x = head != null ? head.next : null;
        }
        x = head;
        ListNode y = x != null ? x.next : null;
        while (y != null) {
            if (y.next != null && y.next.val == y.val) {
                while (y != null && y.val == x.next.val)
                    y = y.next;
                x.next = y;
            }else{
                x = x.next;
                y = y.next;
            }               
        }
        return head;
    }
}