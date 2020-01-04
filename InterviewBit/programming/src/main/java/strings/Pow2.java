package strings;

public class Pow2 {
	
	
	static String devideByTwo(String str){
		StringBuffer sb = new StringBuffer(str);
		String res = "";
		boolean firstTime = true;
		while(sb.length()>0){
			
			String f = sb.substring(0, 1);
			if(Integer.parseInt(f)<2){
				if(Integer.parseInt(f)==0){
					res = res + Integer.parseInt(f)/2;
					sb.delete(0, 1);
					continue;
				}
				f = sb.substring(0,2);
				sb.delete(0, 2);
				if(firstTime==false)
					res = res + "0";
			}else{
				sb.delete(0, 1);
			}
			firstTime = false;
			if(Integer.parseInt(f)%2!=0){
				sb.insert(0, 1);
				firstTime = true;
			}
			res = res + Integer.parseInt(f)/2;
			
		}
		return res;
	}
	
	static public int power(String A) {
		if(A.length()==1){
			if(A.charAt(0)=='0' || A.charAt(0)=='1')
				return 0;
		}
		
		while(A.charAt(A.length()-1)=='0' || A.charAt(A.length()-1)=='2' || A.charAt(A.length()-1)=='4' || A.charAt(A.length()-1)=='6' || A.charAt(A.length()-1)=='8'){			
			A = devideByTwo(A);			
		}
		if(A.length()==1 && A.charAt(0)=='1')
			return 1;
		return 0;
    }
	public static void main(String[] args) {
		
		String str = "100";
		
		
		System.out.println(power(str));
		
		
	}

}
