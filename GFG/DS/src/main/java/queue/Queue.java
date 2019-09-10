package queue;

public class Queue {

	private Integer[] queueData;
	private int rear, front, size;

	public Queue(int capacity) {
		queueData = new Integer[capacity];
		rear = front = size = 0;

	}
	
	public boolean isEmpty(){
		if(size==0)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if (size == queueData.length)
			return true;
		return false;
	}

	public void enqueue(int data) {

		if (size == queueData.length)
			throw new IllegalArgumentException();
		queueData[rear] = data;
		rear = (rear + 1) % queueData.length;
		size = size + 1;
	}

	public int dequeue() {

		if (size == 0)
			throw new IllegalArgumentException();
		int data = queueData[front];
		front = (front + 1) % queueData.length;
		size = size - 1;
		return data;
	}

	public int front() {
		if (size == 0)
			throw new IllegalArgumentException();
		return queueData[front];
	}

	public int rear() {
		if (size == queueData.length)
			throw new IllegalArgumentException();
		return queueData[rear];
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.enqueue(1);
		queue.enqueue(1);
		// queue.enqueue(2);
	}

}
