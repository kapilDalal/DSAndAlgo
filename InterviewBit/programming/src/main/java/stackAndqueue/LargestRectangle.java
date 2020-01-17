package stackAndqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
	
	static public int largestRectangleArea(ArrayList<Integer> A) {
        if(A.size()==1)
            return A.get(0);
        
        int area = Integer.MIN_VALUE;
        for(int i=0;i<A.size()-1;i++){
            for(int j=i;j<A.size();j++){
                int h = min(i,j,A);
                int w = j-i+1;
                if(area<h*w)
                    area = h*w;
            }
        }
        return area;
        
    }
    static public int min(int i,int j,ArrayList<Integer> A){
        int min = Integer.MAX_VALUE;
        for(;i<=j;i++)
            min = Math.min(min,A.get(i));
        return min;
    }
    static public int largestRectangleAreaOptimised(ArrayList<Integer> A) {
        if(A.size()==1)
            return A.get(0);
        
        Stack<Integer> s = new Stack<Integer>();
        
        int area = Integer.MIN_VALUE;
        int i=0;
        for(;i<A.size()-1;i++){
            if(s.isEmpty()){
            	s.push(i);
            	continue;
            }
            
            while(s.peek()<A.get(i)){
            	int w = i - s.pop();
            	int h = A.get(i);
            	if(area<h*w)
            		area = h*w;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
        	int top = s.pop();
        	
        	int height = A.get(top);
        	int w = s.isEmpty() ? i : (i-s.peek());
        }
        
        return area;
        
    }
	
	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new ArrayList<Integer>(Arrays.asList(2, 1, 5, 6, 2, 3))));
	}

}
