package stack;

public class StackWithGetMin {
	
	private Integer[] arr;
	private Integer[] min;
	private int top;
	private int minIndex;

	public StackWithGetMin(int capacity) {
		arr = new Integer[capacity];
		min = new Integer[capacity];
		minIndex = -1;
		top = -1;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public boolean push(Integer data) {
		
		if (top < arr.length-1) {
			top = top + 1;
			arr[top] = data;
			
			if(minIndex==-1){
				minIndex = minIndex+1;
				min[minIndex] = data;
			}
			else if (data<min[minIndex]){
				minIndex = minIndex+1;
				min[minIndex] = data;
			}
				
			
			return true;
		}
		return false;
	}

	public Integer pop() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		Integer popped = arr[top];
		top--;
		if(minIndex!=-1 && min[minIndex]==popped)
			minIndex = minIndex-1;
		return popped;
	}
	
	public Integer getMin(){
		if(minIndex==-1)
			throw new ArrayIndexOutOfBoundsException();
		Integer minimium = min[minIndex];		
		return minimium;
	}

	public Integer peek() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		Integer popped = arr[top];
		return popped;
	}
	
	public static void main(String[] args) {
		StackWithGetMin s = new StackWithGetMin(5);
		s.push(18); 
	    s.push(19); 
	    s.push(29); 
	    System.out.println(s.getMin()); 
	    s.push(17); 
	    System.out.println(s.getMin()); 
	    s.push(16);
	    System.out.println(s.getMin());
	    s.pop();
	    System.out.println(s.getMin());
	    s.pop();
	    System.out.println(s.getMin());
		
	}

}
