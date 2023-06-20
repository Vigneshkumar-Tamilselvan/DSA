package mandatoryHomeWork.week4.Day_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class ListNode {

	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}

}

public class Remove_Duplicates_from_Sorted_List_83 {

	@Test
	public void test2() {
		ListNode head = create_List(new int[] { 1, 1, 2, 3, 3 });
		ListNode expected = create_List(new int[] { 1, 2, 3 });
		assertEquals(remove_Duplicates(head), expected);
	}

	public ListNode remove_Duplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;

		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		return head;

	}

	private ListNode create_List(int[] head) {
		ListNode input = new ListNode(0);
		ListNode current = input;

		for (int value : head) {
			current.next = new ListNode(value);
			current = current.next;
		}

		return input.next;
	}

}
