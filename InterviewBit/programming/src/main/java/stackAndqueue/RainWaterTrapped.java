package stackAndqueue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {

	static public int trap(final List<Integer> A) {
		int area = 0;
		
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i<A.size();i++){
			
			int ele = A.get(i);			
			if(s.isEmpty()){
				s.push(ele);
				continue;				
			}
			if(A.get(s.peek())>ele){
				s.push(i);
			}
			else{
				
				if(s.size()==1) //not sure about this step, need to think again about this.
					s.pop();
				else{
					int first = s.pop();
					int sec = s.pop();
					int w = i - sec - 1;
					int h = A.get(sec) - A.get(first);
					
					area = area + w*h;
					
				}
				s.push(i);
			}						
		}				
		return area;
    }	
	
	public static void main(String[] args) {
		trap(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));
		System.out.println(trap(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
	}
	
}
