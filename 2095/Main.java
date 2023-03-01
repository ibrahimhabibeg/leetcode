class Main {
  public static void main(String[] args) {

  }

  public ListNode deleteMiddle(ListNode head) {
    int size = 1;
    ListNode currentNode = head.next;
    while (currentNode != null) {
      size++;
      currentNode = currentNode.next;
    }
    if (size == 1) {
      return null;
    }
    currentNode = head;
    for (int i = 0; i < size / 2 - 1; i++) {
      currentNode = currentNode.next;
    }
    currentNode.next = currentNode.next.next;
    return head;
  }
}