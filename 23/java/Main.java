import java.util.Comparator;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args) {
        
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, Comparator.comparing(node->node.val));
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                minHeap.add(lists[i]);
            }
        }
        ListNode res = new ListNode();
        ListNode currentNode = res;
        while(minHeap.size()>0){
            ListNode smallestNode = minHeap.poll();
            currentNode.next = new ListNode(smallestNode.val);
            currentNode = currentNode.next;
            if(smallestNode.next != null){
                minHeap.add(smallestNode.next);
            }
        }
        currentNode.next = null;
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