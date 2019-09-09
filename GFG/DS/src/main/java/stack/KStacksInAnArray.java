package stack;

public class KStacksInAnArray {
	
	Integer[] arr;
	Integer[] top;
	Integer numberOfStacks;
	
	public KStacksInAnArray(int capacity,int numberOfStacks){
		arr = new Integer[capacity];
		top = new Integer[numberOfStacks];
		this.numberOfStacks = numberOfStacks;
		
		for(int i=0;i<numberOfStacks;i++){
			top[i] = i * (capacity/numberOfStacks);
		}
		
	}
	
	public void push(int data,int stackNumber){
		if(stackNumber<0 || stackNumber>numberOfStacks)
			throw new IllegalArgumentException();
		
		stackNumber = stackNumber-1;
		
		if(top[stackNumber]<((((stackNumber+1)*arr.length)/numberOfStacks))){
			arr[top[stackNumber]] = data;
			top[stackNumber] = top[stackNumber]+1;
		}
		else
			throw new IndexOutOfBoundsException("capacity exceeded for stack "+(stackNumber+1));		
	}
	
	
	
	public static void main(String[] args) {
		KStacksInAnArray threeStacks = new KStacksInAnArray(8, 3);
		threeStacks.push(1, 1);
		threeStacks.push(2, 2);
		threeStacks.push(3, 3);
		
		threeStacks.push(5, 1);
		threeStacks.push(6, 2);
		threeStacks.push(7, 3);
		
		threeStacks.push(9, 3);
		threeStacks.push(10, 3);
		threeStacks.push(1, 1);
	}

}
