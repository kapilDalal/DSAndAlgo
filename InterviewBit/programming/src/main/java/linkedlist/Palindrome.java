package linkedlist;

import java.util.Arrays;
import java.util.List;

import linkedlist.DeleteNodeFromLast.ListNode;

public class Palindrome {
	
	static public int lPalin(ListNode A) {
        List<Integer> l = Arrays.asList(418 , 381 , 96 , 356 , 411 , 336 , 94 , 433 , 315 , 29 , 140 , 194 , 333 , 489 , 440 , 433 , 469 , 402 , 228 , 228 , 264 , 499 , 318 , 182 , 159 , 159 , 182 , 318 , 499 , 264 , 228 , 228 , 402 , 469 , 433 , 440 , 489 , 333 , 194 , 140 , 29 , 315 , 433 , 94 , 336 , 411 , 356 , 96 , 381 , 418);
        /*while(A!=null){
            l.add(A.val);
            A = A.next;
        }*/
        
        int start = 0;
        int end = l.size()-1;
        while(start<end){
            if(l.get(start).intValue()!=l.get(end).intValue()){
                System.out.println(l.get(start)+"\t"+l.get(end));
                return 0;
            }
            start++;
            end--;
        }
        
        return 1;
    }
	public static void main(String[] args) {
		lPalin(null);
		System.out.println(lPalin(null));
	}

}
