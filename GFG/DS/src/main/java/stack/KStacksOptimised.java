package stack;

public class KStacksOptimised {

	Integer[] top;
	Integer[] stackData;
	Integer[] nextIndex;

	int nextAvailable = 0;

	public KStacksOptimised(int capacity, int numberOfStacks) {
		stackData = new Integer[capacity];
		top = new Integer[numberOfStacks];
		nextIndex = new Integer[capacity];
		for (int i = 0; i < numberOfStacks; i++) {
			top[i] = -1;
		}
		for (int i = 0; i < capacity; i++) {
			nextIndex[i] = i + 1;
		}
		nextIndex[capacity - 1] = -1;
	}

	public void push(int stackNumber, int data) {

		if (stackNumber < 1 || stackNumber > top.length)
			throw new IllegalArgumentException("Invalid stack number");

		if (nextAvailable == -1)
			throw new IllegalArgumentException("no room left");

		stackNumber = stackNumber - 1;

		stackData[nextAvailable] = data;
		int nextFree = nextIndex[nextAvailable];
		nextIndex[nextAvailable] = top[stackNumber];
		top[stackNumber] = nextAvailable;

		nextAvailable = nextFree;

	}

	public int pop(int stackNumber) {
		if (stackNumber < 1 || stackNumber > top.length)
			throw new IllegalArgumentException("Invalid stack number");
		stackNumber = stackNumber - 1;

		if (top[stackNumber] == -1)
			throw new IllegalArgumentException("no item left in stack" + (stackNumber + 1));

		int popped = stackData[top[stackNumber]];
		int nextFree = top[stackNumber];
		top[stackNumber] = nextIndex[top[stackNumber]];
		nextIndex[nextFree] = nextAvailable;

		nextAvailable = nextFree;

		return popped;
	}

	public static void main(String[] args) {
		KStacksOptimised threeStacks = new KStacksOptimised(6, 3);
		threeStacks.push(1, 3);
		threeStacks.push(1, 6);
		threeStacks.push(3, 7);
		threeStacks.pop(1);
		threeStacks.pop(3);
		threeStacks.pop(1);
		threeStacks.pop(3);
	}

}
