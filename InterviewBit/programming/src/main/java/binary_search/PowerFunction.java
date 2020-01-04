package binary_search;

import java.util.HashMap;

public class PowerFunction {
	
	static HashMap<Long,Long> map = new HashMap<Long,Long>();
	static int pow(int x,int n,int d){
		if(x==0)
			return 0;		
		if(n==0)
			return 1;
		if(n==1)
			return (x+d)%d;
		
		if(map.containsKey(n))
			return map.get(n).intValue();
		
		long res = 1L*pow(x,n/2,d)%d*pow(x,n-n/2,d)%d;
		
		map.put((long) n, res%d);
		
		return (int)(res+d)%d;		
	}
	public static void main(String[] args) {
		System.out.println(pow(-1, 1, 20));
		//System.out.println(Math.pow(-1, 1)/20);
	}

}
