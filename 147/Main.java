class Main {
  public static void main(String[] args) {
    ListNode head = new ListNode(-1);
    ListNode loopingNode = head;
    loopingNode.next = new ListNode(5);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(3);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(4);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(0);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(3);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(2);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(7);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(4);
    loopingNode = loopingNode.next;
    loopingNode.next = new ListNode(-5);
    Main main = new Main();
    ListNode res = main.insertionSortList(head);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  public ListNode insertionSortList(ListNode head) {
    ListNode x = head.next;
    while (x != null) {
      int key = x.val;
      ListNode y = head;
      while (y.val < key) {
        y = y.next;
      }
      int newVal = y.val;
      y.val = key;
      while (y != x) {
        y = y.next;
        int temp = y.val;
        y.val = newVal;
        newVal = temp;
      }
      x = x.next;
    }
    return head;
  }

}
