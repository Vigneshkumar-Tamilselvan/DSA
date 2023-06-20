package mandatoryHomeWork.week6.Day_1;

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
