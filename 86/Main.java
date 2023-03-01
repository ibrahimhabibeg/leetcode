class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(4,
                new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(11,new ListNode(0)))))));
        ListNode res = main.partition(head, 3);
        while (res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    //[78,-51,8,0,4,6,-5,1,7,5,41,2,4,32,-4,0,4,7,8,2,-41,71,100,-100,52,4,-62,1,0,7,2,3,0,7,9,2,-7,0,5,0,6,8,1,-2,0,5,7,-5,1,-8,5]

    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode pivot = null;
        if (head.val < x) {
            pivot = head;
            while (pivot.next!=null && pivot.next.val<x) {
                pivot = pivot.next;
            }
            if(pivot.next==null || pivot.next.next == null){
                return head;
            }
        }
        ListNode y = head;
        if(pivot!=null){
            y = pivot.next;
        }
        ListNode z = y.next;
        while (z != null) {
            if (z.val < x ) {
                y.next = z.next;
                if (pivot == null) {
                    z.next = head;
                    head = z;
                    pivot = head;
                } else {
                    z.next = pivot.next;
                    pivot.next = z;
                    pivot = pivot.next;
                }
                z = y.next;
            }else{
                y = z;
                z = z.next;
            }
        }
        return head;
    }
}