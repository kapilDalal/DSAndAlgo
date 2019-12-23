package math;

public class TrailingZeros {
	
	public int trailingZeroes(int A) {
		int count = 0; 
		  
        // Keep dividing A by powers of  
        // 5 and update count 
        for (int i = 5; A / i >= 1; i *= 5) 
            count += A / i; 
  
        return count; 
    }

	public static void main(String[] args) {
		TrailingZeros tz = new TrailingZeros();
		;
		System.out.println(tz.trailingZeroes(28));
	}

}
