package strings;

public class SubstringUsingKMP {	
	public boolean Kmp(char[] str,char[] pattern){
		int[] patternSuffixEqualsPrefix = getPattenSuffixEqualsPrefix(pattern);
		int i=0;
		int j=0;
		
		while(i<str.length && j<pattern.length){
			
			if(str[i]==pattern[j]){
				i++;
				j++;
			}
			else{
				if(j!=0){
					j=patternSuffixEqualsPrefix[j-1];
				}else{
					i++;
				}
			}
			
		}
		
		if(j==pattern.length)
			return true;
		
		return false;
	}
	
	
	private int[] getPattenSuffixEqualsPrefix(char[] pattern) {
		int[] sp = new int[pattern.length];
		int index = 0;
		sp[0] = 0;
		for(int i=1;i<pattern.length;){			
			if(pattern[i]==pattern[index]){
				sp[i] = index+1;
				index++;
				i++;
			}
			else{
				if(index!=0){
					index = sp[index-1];
				}else{
					sp[i]=0;
					i++;
				}
			}
			
		}
		return sp;
	}


	public static void main(String[] args) {
		 String str = "aaaabaaeaaaabaadaaaabaaa";
	     String pattern = "aaaabaaa";
	     SubstringUsingKMP kmp = new SubstringUsingKMP();
	     
	     System.out.println(kmp.Kmp(str.toCharArray(), pattern.toCharArray()));
	     
	}

}
