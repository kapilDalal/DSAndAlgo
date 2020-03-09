package graph;

public class SumOfFibNumbers {
	static int fib(long target){
		int f1 = 1;
		int f2 = 1;
		int next = 1;
		while(next<=target){
			next = f1 + f2;
			if(next>=target)
				break;
			f1 = f2;
			f2 = next;
		}
		if(next<=target)
			return next;
		return f2;
	}
	
	static public int fibsum(int A) {
		int cnt=0;
		while(A>0){
			A = A - fib(A);
			cnt++;
		}
		return cnt;
    }
	public static void main(String[] args) {
		System.out.println(fibsum(117));
	}

}
