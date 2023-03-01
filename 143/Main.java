import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Main main = new Main();
        main.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        int n = 1;
        ListNode x = head;
        while (x.next != null) {
            n++;
            x = x.next;
        }
        Queue<ListNode> queue = new LinkedList<ListNode>();
        Stack<ListNode> stack = new Stack<ListNode>();
        x = head;
        for (int i = 0; i < n; i++) {
            if (i < (n + 1) / 2) {
                queue.add(x);
            } else {
                stack.add(x);
            }
            x = x.next;
        }
        for (int i = 0; i < n / 2; i++) {
            ListNode first = queue.poll();
            ListNode second = stack.pop();
            first.next = second;
            second.next = queue.peek();
        }
        if (queue.peek() != null) {
            queue.peek().next = null;
        }
    }
}