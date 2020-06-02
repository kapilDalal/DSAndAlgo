package graph;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class SmallestMultipleWith0and1 {
	
	public String multiple(int A) {
		BigInteger first = new BigInteger(String.valueOf(1));
		BigInteger a = new BigInteger(String.valueOf(A));
		BigInteger rem = new BigInteger(String.valueOf("0"));
		BigInteger polled = first;
		Queue<BigInteger> q = new LinkedList<BigInteger>();
		q.add(first);
		while(polled.mod(a).intValue()!=rem.intValue()) {
			polled = q.poll();
			String f = polled.toString() + "0";
			String s = polled.toString() + "1";
			q.add(new BigInteger(f));
			q.add(new BigInteger(s));
		}				
		return polled.toString();
    }
	public static void main(String[] args) {
		SmallestMultipleWith0and1 sm = new SmallestMultipleWith0and1();
		String multiple = sm.multiple(550);
		System.out.println(multiple);
	}

}
