package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HammingDistance {

	public class Key{
        int first;
        int second;
        public Key(int f,int s){
            this.first = f;
            this.second = s;
        }
        @Override
        public boolean equals(Object obj) {
        	final Key k = (Key) obj;
            if(this.first==k.second && this.second==k.first)
                return true;
            return false;
        }
    }
	
	static public int hammingDistance(final List<Integer> A) {
		int res = 0;
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.size(); j++) {
				if(i!=j){
					int f = A.get(i);
					int s = A.get(j);
					
					String strF = String.valueOf(f);
					String strS = String.valueOf(s);
					String con =  strF +"00"+ strS;
					String rev = strS+"00"+ strF;
					
					if(map.containsKey(Long.parseLong(rev))){
						int numOf1s = map.get(Long.parseLong(rev));
						res = (res + numOf1s)%1000000007;
					}
					else{
						int xor = f ^ s;
						int num1s = numOfOne(xor);
						map.put(Long.parseLong(con), num1s);
						res = (res + num1s)%1000000007;
					}
				}
			}
		}
		
		return res;

	}

	private static int numOfOne(int xor) {
		// TODO Auto-generated method stub
		int num1s = 0;
		
		while(xor!=0){
			num1s = num1s + xor%2 ;
			xor = xor/2;
		}
		
		return num1s;
	}
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(96, 58, 91, 74, 86, 5, 73, 5, 56, 96, 53, 85, 83);
		;
		System.out.println(hammingDistance(A));
	}
}
