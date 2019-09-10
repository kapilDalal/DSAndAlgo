package queue;

import stack.StackInt;

public class QueueUsingStacks {
	
	StackInt stack1;
	StackInt stack2;
	
	public QueueUsingStacks(int capacity) {
		stack1 = new StackInt(capacity);
		stack2 = new StackInt(capacity);
	}
	
	public void enqueue(int data){
		if(stack1.isFull()){
			System.out.println("can not enter more data queue is full");
			return;
		}
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		stack1.push(data);
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}
	
	public int dequeue(){
		
		if(stack1.isEmpty()){
			System.out.println("no data in the queue");
			return Integer.MIN_VALUE;
		}
		return stack1.pop();
	}
	
	
	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks(4);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
