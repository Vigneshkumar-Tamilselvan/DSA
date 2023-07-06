package selfLearn.linkedList;

import org.junit.Test;

public class SinglyLinkedListImplementation {

	public class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void printLinkedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	@Test
	public void createList_static() {
		Node p1 = new Node(1);
		Node p2 = new Node(1);
		Node p3 = new Node(2);
		Node p4 = new Node(3);
		Node p5 = new Node(3);

		Node head = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;

		printLinkedList(head);
	}
	
	private ListNode createList_dynamic(int[] head) {
		ListNode input = new ListNode(0);
		ListNode current = input;

		for (int value : head) {
			current.next = new ListNode(value);
			current = current.next;
		}

		return input.next;
	}

}
