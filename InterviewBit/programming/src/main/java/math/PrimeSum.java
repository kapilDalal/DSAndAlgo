package math;

import java.util.ArrayList;

public class PrimeSum {
	
	 static public ArrayList<Integer> primesum(int A) {
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        ArrayList<Integer> res1 = new ArrayList<Integer>();
	        boolean[] primes = new boolean[A+1];
	        for(int i=0;i<primes.length;i++)
	        	primes[i] = true;
	        for(int i=2;i<Math.sqrt(A);i++){
	        	if(primes[i]==true){
	        		for(int j=2;i*j<A;j++)
	        			primes[i*j] = false;
	        	}
	        }
	        for(int i=2;i<primes.length-1;i++){
	        	if(primes[i]==true)
	        		res.add(i);
	        }
	        //System.out.println(res);
	        int start=0,end = res.size()-1;
	        while(start<end){
	        	int startNum = res.get(start);
	        	int endNum = res.get(end);
	        	if(startNum*2==A){
	        		res1.add(startNum);
	        		res1.add(startNum);
	        		break;
	        	}
	        	if(endNum*2==A){
	        		res1.add(endNum);
	        		res1.add(endNum);
	        		break;
	        	}
	        	if(startNum+endNum==A){
	        		res1.add(startNum);
	        		res1.add(endNum);
	        		break;
	        	}
	        	else if(startNum+endNum<A){
	        		start++;
	        	}
	        	else
	        		end--;
	        }
	        
	        return res1;	        	
	    }
	
	public static void main(String[] args) {
		;
		System.out.println(primesum(4));
	}

}
