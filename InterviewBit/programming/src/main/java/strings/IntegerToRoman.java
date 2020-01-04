package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerToRoman {


    static public String intToRoman(int A) {
    	
    	ArrayList<Integer> ints= new ArrayList<Integer>(Arrays.asList(1,4,5,9,10,40,50,90,100,400,500,900,1000));
    	ArrayList<String> roms= new ArrayList<String>(Arrays.asList("I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"));    	
    	String res = "";
    	
    	
    	while(A>0){
    		int i= ints.size()-1;
    		
    		for(;i>=0;i--){
    			if(ints.get(i)<=A){
    				A -= ints.get(i);
    				break;
    			}
    		}
    		res = res + roms.get(i);    		
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		System.out.println(intToRoman(1900));
	}
	
}
