class Main{
    public static void main(String[] args) {
        
    }
    public ListNode middleNode(ListNode head) {
        ListNode res = head;
        ListNode reachingEnd = head;
        while (reachingEnd!=null && reachingEnd.next!=null) {
            res = res.next;
            reachingEnd = reachingEnd.next.next;
        }
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}