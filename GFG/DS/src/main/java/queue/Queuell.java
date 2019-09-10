package queue;

public class Queuell {
	Node front, rear;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Queuell() {
		this.front = this.rear = null;
	}

	public void enqueue(int data) {
		if (this.rear == null) {
			this.front = this.rear = new Node(data);
			return;
		}
		this.rear.next = new Node(data);
		this.rear = this.rear.next;
	}

	public int dequeue() {
		if (this.front == null)
			throw new IllegalArgumentException();
		int data = front.data;
		Node temp = front;
		front = front.next;
		temp.next = null;
		return data;
	}

	public static void main(String[] args) {
		Queuell queue = new Queuell();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.enqueue(1);
		
		System.out.println(queue.front.data);
		System.out.println(queue.rear.data);
		// queue.enqueue(2);
	}
}
