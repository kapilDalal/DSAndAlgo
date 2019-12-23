package math;

/*
	You are given two positive numbers A and B. You need to find the maximum valued integer X such that:
	
	X divides A i.e. A % X = 0
	X and B are co-prime i.e. gcd(X, B) = 1
	For example,
	
	A = 30
	B = 12
	We return
	X = 5
 */

class LargestCoprimeDivisor implements Cloneable{
	
	public int cpFact(int A, int B) {
		
		
		int res = 0;
		
		for(int i=A;i>=1;i--){
			if(A%i==0 && gcd(B,i)==1){
				return i;
			}
		}
		
		return res;
    }
	
	private int gcd(int a, int b) {
		if(a%b==0)
			return b;
		return gcd(b,a%b);
	}
	public static void main(String[] args) {
		LargestCoprimeDivisor lcd = new LargestCoprimeDivisor();
		System.out.println(lcd.cpFact(30, 12));
		//lcd.arrange(Arrays.asList(4, 0, 2, 1, 3));
		System.out.println('a'<'c');
	}

}
