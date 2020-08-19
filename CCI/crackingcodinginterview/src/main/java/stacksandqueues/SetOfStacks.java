package stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack<Integer>> listOfStacks;
	int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		listOfStacks = new ArrayList<>();
		listOfStacks.add(new Stack<Integer>());
	}

	public void push(int val) {
		Stack<Integer> s = listOfStacks.get(listOfStacks.size() - 1);
		if (s.size() < capacity) {
			s.push(val);
		} else {
			Stack<Integer> n = new Stack<Integer>();
			n.push(val);
			listOfStacks.add(n);
		}
	}

	public int pop() {
		Stack<Integer> s = listOfStacks.get(listOfStacks.size() - 1);
		if (s.size() == 0) {
			listOfStacks.remove(listOfStacks.size() - 1);
			if (listOfStacks.size() == 0)
				return -1;// no stack available.
			s = listOfStacks.get(listOfStacks.size() - 1);
		}
		return s.pop();
	}
	
	public int popFollowUp(int stackNumber) 
	{
		Stack<Integer> s = listOfStacks.get(stackNumber - 1);
		if (s.size() == 0) {
			return -1;
		}
		return s.pop();
		
	}
	
	public static void main(String[] args) {
		SetOfStacks ss = new SetOfStacks(2);
		ss.push(2);
		ss.push(3);
		
		ss.push(4);
		ss.push(5);
		
		ss.push(6);
		ss.push(7);
		
		;
		System.out.println(ss.popFollowUp(1));
		
	}

}
