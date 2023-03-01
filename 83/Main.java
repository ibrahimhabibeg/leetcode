class Main {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode x = head;
        ListNode y = x == null ? null : x.next;
        while (y != null) {
            if (y.val == x.val){
                x.next = y.next;
                y = x.next;
            }else{
                x = x.next;
                y = x == null ? null : x.next;
            }
        }
        return head;
    }
}