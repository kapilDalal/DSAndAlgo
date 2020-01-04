package strings;

import java.util.ArrayList;

public class ZigzagStrings {

	public String convert(String A, int B) {
		if(B<=1)
			return A;
		String res = "";
        ArrayList<StringBuffer> zigStrings = new ArrayList<StringBuffer>();
        for(int i=0;i<B;i++){
            StringBuffer str = new StringBuffer();
            zigStrings.add(str);
        }
        int index = 0;
        boolean iOrd = true;
        for(int i=0;i<A.length();i++){            
            zigStrings.get(index).append(A.charAt(i));
            if(index==B-1){
            	iOrd = false;
            }            	
            if(iOrd==true){
            	index++;
            }else{
            	if(index==0){
            		iOrd = true;
            		index++;
            	}else{
            		index--;
            	}
            }
        }
        for(int i=0;i<zigStrings.size();i++)
        	res += zigStrings.get(i);
        return res;
    }
	public static void main(String[] args) {
		ZigzagStrings zs = new ZigzagStrings();
		System.out.println(zs.convert("ABCD", 1));
	}
	
}
