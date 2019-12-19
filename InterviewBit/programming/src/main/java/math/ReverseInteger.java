package math;

public class ReverseInteger {

	static public int reverse(int A) {
		int res = 0;
		boolean neg = false;
		if (A < 0){
			neg = true;
			A = Math.abs(A);
		}
		String str = "";
		while (A != 0) {
			int num = A % 10;
			A = A / 10;
			str = str+String.valueOf(num) ;
		}
		try{
			res = Integer.parseInt(str);
			if(neg)
				res = -1 * res;
		}catch(Exception e){
			return 0;
		}

		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(-10));
	}

}
