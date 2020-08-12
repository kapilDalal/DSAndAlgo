package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class IsUnique {

	//O(n^2)
	public static boolean isUnique(String str) 
	{
		for(int i=0;i<str.length();i++) 
		{
			for(int j=i+1;j<str.length();j++) 
			{
				if(str.charAt(i)==str.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	//O(nlogn)
	public static boolean isUniqueOptimised(String str) 
	{
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		str = new String(ch);		
		for(int i=0;i<str.length()-1;i++) 
		{
			if(str.charAt(i)==str.charAt(i+1))
				return false;
		}		
		return true;
	}
	
	//O(n)
	public static boolean isUniqueMostOptimised(String str) 
	{
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str.length();i++) 
		{
			if(!set.add(str.charAt(i)))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(isUniqueMostOptimised("abc"));
	}
}
