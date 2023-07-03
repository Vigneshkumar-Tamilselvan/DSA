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

		printLinkedList(head);
	}

}
