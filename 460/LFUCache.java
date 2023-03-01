import java.util.HashMap;

/**
 * LFUCache
 */
public class LFUCache {
    int capacity;
    int size;
    int minCount = 0;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    DoublyLinkedListOfList listOfLists = new DoublyLinkedListOfList();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if(capacity==0)
            return -1;
        Node node = map.getOrDefault(key, null);
        if (node != null)
            updateNode(node);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        if(capacity==0)
            return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateNode(node);
            return;
        }
        if (size >= capacity) {
            DoublyLinkedList listToRemoveFrom = listOfLists.head;
            map.remove(listToRemoveFrom.tail.key);
            listToRemoveFrom.removeTail();
            if (listToRemoveFrom.size == 0)
                listOfLists.removeHead();
        }
        Node node = new Node();
        node.key = key;
        node.val = value;
        node.count = 1;
        map.put(key, node);
        updateNewNode(node);
        size++;
    }

    private void updateNode(Node node) {
        node.count++;
        if (node.list.next == null || node.list.next.head.count != node.count) {
            DoublyLinkedList newList = new DoublyLinkedList();
            newList.next = node.list.next;
            newList.prev = node.list;
            if (newList.next != null)
                newList.next.prev = newList;
            node.list.next = newList;
        }
        node.list.removeNode(node);
        if (node.list.size == 0) {
            if (listOfLists.head == node.list) {
                listOfLists.head = listOfLists.head.next;
            } else {
                if (node.list.next != null)
                    node.list.next.prev = node.list.prev;
                node.list.prev.next = node.list.next;
            }
        }
        node.list.next.AddHead(node);
        node.list = node.list.next;
    }

    private void updateNewNode(Node node) {
        if (listOfLists.head == null || listOfLists.head.head.count != 1) {
            DoublyLinkedList newList = new DoublyLinkedList();
            newList.next = listOfLists.head;
            if (listOfLists.head != null)
                listOfLists.head.prev = newList;
            listOfLists.head = newList;
        }
        node.list = listOfLists.head;
        node.list.AddHead(node);
    }
}