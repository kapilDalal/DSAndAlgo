package stack;

public class NextGreaterElement {

	static void nextGreaterElement(Integer[] arr){
		StackInt stack = new StackInt(arr.length);
		int data = arr[0];
		stack.push(data);
		for(int i=1;i<arr.length;i++){
			data = arr[i];
			if(stack.isEmpty())
				stack.push(data);
			else{
				while(!stack.isEmpty() && data>stack.peek()){
					System.out.println(stack.pop()+" --> "+data);
				}
			}
			stack.push(data);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" --> "+"-1");
		}		
	}
	public static void main(String[] args) {
		Integer[] arr = {11, 13, 21, 3};
		nextGreaterElement(arr);
	}
	
}
