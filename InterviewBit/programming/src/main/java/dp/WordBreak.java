package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class WordBreak {
	
	
	
	static public class Data implements Comparable<Data>{
        int val;
        int index;
        public Data(int val,int index){
            this.val = val;
            this.index = index;
        }
        
		@Override
		public int compareTo(Data arg0) {
			// TODO Auto-generated method stub
			return this.val-arg0.val;
		}
    }
    public int maxArr(ArrayList<Integer> A) {
        ArrayList<Data> data = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            Data d = new Data(A.get(i),i);
            data.add(d);
        }
        Collections.sort(data);
        int left=0;
        int right = data.size();
        int max = 0;
        while(left<right){
            Data l = data.get(left);
            Data r = data.get(right);
            int diff = Math.abs(l.val-r.val)+Math.abs(l.index-r.index);
            max = Math.max(max,diff);
            
        }
        return max;
    }
	
	static HashSet<String> set = new HashSet<>();
    public static int wordBreak(String A, String[] B) {
        
        for(int i=0;i<B.length;i++)
            set.add(B[i]);
        
        //System.out.println(cnt);
        if(wb(A)){
        	set.clear();
            return 1;
        }
        set.clear();
        return 0;
    }
    public static boolean wb(String word) 
    { 
        int size = word.length(); 
          
        // base case 
        if (size == 0) 
        return true; 
          
        //else check for all words 
        for (int i = 1; i <= size; i++) 
        { 
            // Now we will first divide the word into two parts , 
            // the prefix will have a length of i and check if it is  
            // present in dictionary ,if yes then we will check for  
            // suffix of length size-i recursively. if both prefix and  
            // suffix are present the word is found in dictionary. 
  
            if (set.contains(word.substring(0,i)) &&  
                    wb(word.substring(i,size))) 
            return true; 
        } 
          
        // if all cases failed then return false 
        return false; 
    } 

	public static void main(String[] args) {
		System.out.println(wordBreak("abababababaaaabaabbbabbbabbababbb", new String[]{"abbbabaa", "baabaaaab", "babaaaaaba", "b", "b", "bbaaaab", "aaabbb", "aabbbbbab", "abbb", "abaa", "aaababaab", "aabbabaa", "bab", "bbbbaabbb"}));
	}
}
