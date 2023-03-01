class Main{
    public static void main(String[] args) {
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode currentRes = res;
        int c = 0;
        while (l1!=null&&l2!=null) {
            int s = l1.val + l2.val+c;
            c = s/10;
            currentRes.next = new ListNode(s%10);
            currentRes = currentRes.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1!=null) {
            while (l1!=null) {
                int s = l1.val+c;
                c = s/10;
                currentRes.next = new ListNode(s%10);
                currentRes = currentRes.next;
                l1 = l1.next;
            }
        }else if(l2!=null){
            while (l2!=null) {
                int s = l2.val+c;
                c = s/10;
                currentRes.next = new ListNode(s%10);
                currentRes = currentRes.next;
                l2 = l2.next;
            }
        }
        if(c!=0){
            currentRes.next = new ListNode(c);
        }
        return res.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}