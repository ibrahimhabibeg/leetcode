class Main {
	public static void main(String[] args) {
		ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
		ListNode head2 = new ListNode(-1);
		Main main = new Main();
		ListNode res = main.sortList(head2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode sortList(ListNode head) {
		if(head == null){
			return null;
		}
		if (head.next == null) {
			return head;
		}
		int size = 1;
		ListNode x = head;
		while (x.next != null) {
			size++;
			x = x.next;
		}
		x = head;
		for (int i = 0; i < size / 2 - 1; i++) {
			x = x.next;
		}
		ListNode y = x.next;
		x.next = null;
		return mergeTwoLists(sortList(head), sortList(y));
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
				ListNode x = list2;
				list2 = list2.next;
				x.next = list1.next;
				list1.next = x;
			}
			list1 = list1.next;
		}
		if (list1.next == null) {
			list1.next = list2;
		}
		return head;
	}
}