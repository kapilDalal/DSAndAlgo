package math;

public class Gcd {
	
	static public int gcd(int A,int B){
		if(A%B==0)
			return B;
		return gcd(B,A%B);
	}
	public static void main(String[] args) {
		System.out.println(gcd(9,12));
	}

}
