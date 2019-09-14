package queue;

public class KQueuesInOneArray {

	Integer[] front;
	Integer[] rear;
	Integer[] next;
	Integer[] queueData;
	Integer free;

	public KQueuesInOneArray(int capacity, int numberOfQueues) {
		front = new Integer[numberOfQueues];
		rear = new Integer[numberOfQueues];
		next = new Integer[capacity];
		queueData = new Integer[capacity];
		free = 0;

		for (int i = 0; i < numberOfQueues; i++) {
			rear[i] = -1;
			front[i] = -1;
		}

		for (int i = 0; i < capacity; i++) {
			next[i] = i + 1;
		}
		next[capacity - 1] = -1;
	}

	public boolean isEmpty(int queueNumber) {
		if (front[queueNumber] == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		if (free == -1)
			return true;
		return false;
	}

	public void enqueue(int data, int queueNumber) {
		if (isFull()) {
			System.out.println("cann't enqueue as no space left in the queue");
			return;
		}
		int nextFree = next[free];
		if (isEmpty(queueNumber)) {
			front[queueNumber] = rear[queueNumber] = free;
		} else {
			next[rear[queueNumber]] = free;
			rear[queueNumber] = free;
		}
		next[free] = -1;
		queueData[free] = data;
		free = nextFree;
	}

	public int dequeue(int queueNumber) {

		if (isEmpty(queueNumber)) {
			System.out.println("no data left");
			return Integer.MIN_VALUE;
		}

		int frontIndex = front[queueNumber];

		front[queueNumber] = next[frontIndex];

		next[frontIndex] = free;

		free = frontIndex;

		return queueData[frontIndex];
	}

	public static void main(String[] args) {
		int capacity = 10;
		int numberOfQueues = 3;
		KQueuesInOneArray ks = new KQueuesInOneArray(capacity, numberOfQueues);
		// Let us put some items in queue number 2
		ks.enqueue(15, 2);
		ks.enqueue(45, 2);

		// Let us put some items in queue number 1
		ks.enqueue(17, 1);
		ks.enqueue(49, 1);
		ks.enqueue(39, 1);

		// Let us put some items in queue number 0
		ks.enqueue(11, 0);
		ks.enqueue(9, 0);
		ks.enqueue(7, 0);

		System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
		System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
		System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0));
	}

}
