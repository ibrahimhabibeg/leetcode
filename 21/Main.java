class Main {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = list1;
        if (list2.val < list1.val) {
            head = new ListNode(list2.val, list1);
            list2 = list2.next;
            list1 = head;
        }
        while (list1.next != null && list2 != null) {
            if (list2.val < list1.next.val) {
                list1.next = new ListNode(list2.val, list1.next);
                list2 = list2.next;
            }
            list1 = list1.next;
        }
        if (list1.next == null) {
            list1.next = list2;
        }
        return head;
    }
}