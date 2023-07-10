package mandatoryHomeWork.week4.day1;

public class LC21MergeTwoSortedLists {

	public class ListNode {

		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public ListNode create_List(int[] head) {
		ListNode input = new ListNode(0);
		ListNode current = input;

		for (int value : head) {
			current.next = new ListNode(value);
			current = current.next;
		}

		return input.next;
	}

	public void data() {
		ListNode list1 = create_List(new int[] {1,2,4});
		ListNode list2 = create_List(new int[] { 1,3,4});
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		if (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				list1.next = mergeTwoLists(list1.next, list2);
				return list1;
			} else {
				list2.next = mergeTwoLists(list1, list2.next);
				return list2;
			}
		}
		if (list1 == null)
			return list2;
		return list1;
	}
}
