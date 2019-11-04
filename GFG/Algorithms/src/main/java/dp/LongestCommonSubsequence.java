package dp;

public class LongestCommonSubsequence {
	
	
	static int lcsBF(String str1,String str2){
		
		String temp = "";
		for(int i=0;i<str1.length();i++){
			temp = temp + str1.charAt(i);
			if(str2.contains(temp)){				
				int index = str2.indexOf(str1.charAt(i));
				return 1 + lcsBF(str1.substring(i+1, str1.length()),str2.substring(index+1, str2.length()));
			}
			temp = "";
		}
		//System.out.println(cnt);
		return 0;
	}
	
	
	static void lcsUsingDp(String str1,String str2){
		int[] lcs = new int[str1.length()];
		
		for(int i=0;i<lcs.length;i++)
			lcs[i] = 0;
		
		
		for(int i=0;i<str1.length();i++){
			String temp = "";
			temp = temp + str1.charAt(i);
			if(str2.contains(temp)){
				lcs[i] = lcs[i]+1;
				for(int j=0;j<i;j++){
					if(jIsBeforeIinStr2(str1.charAt(j),temp,str2) && lcs[j]+1>lcs[i]){
						lcs[i] = lcs[j] + 1;						
					}
					
					
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<lcs.length;i++){
			if(lcs[i]>max)
				max = lcs[i];
		}
		System.out.println(max);
	}
	
	private static boolean jIsBeforeIinStr2(char j, String temp, String str2) {
		// TODO Auto-generated method stub
		String temp2 = "" + j;
		
		if(str2.contains(temp2) && str2.contains(temp)){
			int index1 = str2.indexOf(temp2.charAt(0));
			int index2 = str2.indexOf(temp.charAt(0));
			if(index1<index2)
				return true;
		}
		
		
		return false;
	}


	public static void main(String[] args) {
		lcsUsingDp("abcd", "abc");
	}

}
