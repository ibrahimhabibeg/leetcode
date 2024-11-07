class Main {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode x = head;
        ListNode y = head.next;
        ListNode z = head.next.next;
        head = y;
        while (y != null) {
            y.next = x;
            if(z != null && z.next!=null){
                x.next = z.next;
            }else{
                x.next = z;
            }
            x = z;
            if(x!=null){
                y = x.next;
            }else{
                y = null;
            }
            if(y!=null){
                z = y.next;
            }else{
                z = null;
            }
        }
        return head;
    }
}