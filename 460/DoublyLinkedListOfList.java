public class DoublyLinkedListOfList {
    DoublyLinkedList head;

    public void removeHead() {
        head = head.next;
        if (head != null)
            head.prev = null;
    }
}
