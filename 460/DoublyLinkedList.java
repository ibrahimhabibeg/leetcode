public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList() {

    }

    public void AddHead(Node node) {
        size++;
        if (head == null)
            tail = node;
        if (head != null)
            head.prev = node;
        node.next = head;
        head = node;
    }

    public void removeTail() {
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void removeNode(Node node) {
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else if (head == node) {
            head = head.next;
        } else if (tail == node) {
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = node.next = null;
    }
}
