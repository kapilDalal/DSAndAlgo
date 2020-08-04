package dp;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumbers {

	
	static int uglyNum(int n) {
		if(n==1)
			return 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashSet<Integer> set = new HashSet<>();	
		pq.add(1);
		set.add(1);
		int cnt = 1;
		while(cnt<n) {
			int num = pq.poll();
			if(!set.contains(num*2)) {
				pq.add(num*2);
				set.add(num*2);
			}
			if(!set.contains(num*3)) {
				pq.add(num*3);
				set.add(num*3);
			}
			if(!set.contains(num*5)) {
				pq.add(num*5);
				set.add(num*5);
			}
			cnt++;
		}
		for(int i=cnt;i<n;i++)
			pq.poll();
		return pq.poll();
	}
	
	//GFG
	
	/*This function divides a by greatest 
    divisible power of b*/
    static int maxDivide(int a, int b) 
    { 
        while(a % b == 0) 
            a = a/b; 
        return a; 
    } 
      
    /* Function to check if a number  
    is ugly or not */
    static int isUgly(int no) 
    { 
        no = maxDivide(no, 2); 
        no = maxDivide(no, 3); 
        no = maxDivide(no, 5); 
          
        return (no == 1)? 1 : 0; 
    } 
      
    /* Function to get the nth ugly  
    number*/
    static int getNthUglyNo(int n) 
    { 
        int i = 1; 
          
        // ugly number count  
        int count = 1;  
          
        // check for all integers  
        // until count becomes n  
        while(n > count) 
        { 
            i++; 
            if(isUgly(i) == 1) 
                count++; 
        } 
        return i; 
    } 
	
	public static void main(String[] args) {
		System.out.println(uglyNum(150));
	}
	
}
