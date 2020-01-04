package bitwise;

public class ReverseBits {

	public long reverse(long a) {
	    long res = 0;
	    int[] setBits = new int[32];
	    for(int i=0;i<32;i++)
	        setBits[i] = 0;
	    for(int i=0;i<32;i++){
	        if((a & 1)==1)
	            setBits[i] = 1;
	        a = a>>1;
	    }
	    
	    
	    for(int i=31;i>=0;i--){
	        res = (long) (res + setBits[i] * Math.pow(2,31-i));
	    }
	    return res;
	}
	public static void main(String[] args) {
		ReverseBits rb = new ReverseBits();
		
		System.out.println(rb.reverse(3));
	}
}
