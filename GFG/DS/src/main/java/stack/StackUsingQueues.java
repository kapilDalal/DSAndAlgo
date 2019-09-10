package stack;

import queue.Queue;

public class StackUsingQueues {

	Queue queue1;
	Queue queue2;

	public StackUsingQueues(int capacity) {
		queue1 = new Queue(capacity);
		queue2 = new Queue(capacity);
	}

	public void push(int data) {
		if (queue1.isFull()) {
			System.out.println("can not push as stack is full");
			return;
		}
		queue2.enqueue(data);
		while (!queue1.isEmpty())
			queue2.enqueue(queue1.dequeue());
		Queue temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		
	}

	public int pop() {
		if (queue1.isEmpty()) {
			System.out.println("stack empty");
			return Integer.MIN_VALUE;
		}
		int data = queue1.dequeue();
		return data;
	}
	
	public int top(){
		if (queue1.isEmpty()) {
			System.out.println("stack empty");
			return Integer.MIN_VALUE;
		}
		int data = queue1.front();
		return data;
	}

	public static void main(String[] args) {
		StackUsingQueues stack = new StackUsingQueues(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
