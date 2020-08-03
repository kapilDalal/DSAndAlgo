package dp;

public class Fibonacci {

	
	static int fn(int n) {
		int num = -1;
		int p1 = 0;
		int p2 = 1;
		if(n==1)
			return p1;
		if(n==2)
			return p2;
		
		for(int i=3;i<=n;i++) {
			num = p1+p2;
			p1 = p2;
			p2 = num;
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(fn(10));
	}
}
