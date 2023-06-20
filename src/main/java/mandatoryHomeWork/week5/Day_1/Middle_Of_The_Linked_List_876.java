package mandatoryHomeWork.week5.Day_1;

import static org.junit.Assert.assertEquals;

public class Middle_Of_The_Linked_List_876 {
	public class ListNode {

		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public void test2() {
		ListNode head = create_List(new int[] { 1, 1, 2, 3, 3 });
		assertEquals(find_Mid(head), 3);
	}

	int length = 0;

	public int find_Mid(ListNode head) {
		if (head == null || head.next == null) {
			return 0;
		} else if (head != null)
			length++;
		System.out.println(length);
		return length / 2;
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

}
