package mandatoryHomeWork.week4.day1;

import org.junit.Test;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LC83RemoveDuplicatesfromSortedList {

	@Test
	public void createList() {
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

		printWithoutDuplicate(head);
	}

	private void printWithoutDuplicate(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			if (current.data == current.next.data)
				current.next = current.next.next;
			System.out.println(current.data);
			current = current.next;
		
		}
	}
}
