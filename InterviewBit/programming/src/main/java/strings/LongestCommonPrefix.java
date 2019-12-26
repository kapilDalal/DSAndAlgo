package strings;

import java.util.ArrayList;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(ArrayList<String> A) {
        boolean br = false;
        int len=0;
        for(int index=0;index<A.get(0).length();index++){
            char ch = A.get(0).charAt(index);
            for(int i=1;i<A.size();i++){
                if(index>A.get(i).length()-1 || ch!=A.get(i).charAt(index)){
                    br = true;  
                    break;
                }                
            }
            
            if(br)
                break;
            len++;
        }
        return A.get(0).substring(0,len);        
    }
	
	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
		A.add("abab");
		A.add("ab");
		A.add("efgh");
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		System.out.println(lcp.longestCommonPrefix(A));
	}

}
