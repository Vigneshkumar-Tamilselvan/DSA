package mandatoryHomeWork.week6.day1;

public class LinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int value) {
			data = value;
			next = null;
		}

	}

	LinkedList() {
		head = null;
	}

}
