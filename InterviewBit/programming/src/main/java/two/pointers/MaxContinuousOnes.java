package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousOnes {
	
	static public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer> res1 = new ArrayList<>();
		ArrayList<Integer> posOfZeros = new ArrayList<>();
		int numOfZeros = 0;
		int numOfContiguousOnesAfterFlip = Integer.MIN_VALUE;
		for(int i=0;i<A.size();i++){
			if(A.get(i).intValue()==0){
				numOfZeros++;
				posOfZeros.add(i);
			}
		}
		if(numOfZeros<=B){
			for(int i=0;i<A.size();i++)
				res.add(i);
			return res;
		}else{
			
			for(int i=0;i<=posOfZeros.size()-B;i++){
				ArrayList<Integer> list = new ArrayList<Integer>(A);
				for(int j=i;j<i+B;j++){
					int index = posOfZeros.get(j);
					list.set(index, 1);
				}
				if(numOfContiguousOnesAfterFlip<numOfContiguousOnes(list).get(0)){
					numOfContiguousOnesAfterFlip = numOfContiguousOnes(list).get(0);
					res1 = new ArrayList<Integer>(numOfContiguousOnes(list));
				}
			}
			
		}
		for(int j=res1.get(1);j<=res1.get(2);j++)
			res.add(j);
		
		return res;
    
	}
	
	static public ArrayList<Integer> numOfContiguousOnes(ArrayList<Integer> A){
		int numOfOnes = Integer.MIN_VALUE;
		ArrayList<Integer> res = new ArrayList<>();
		int ones = 0;
		int lastStart=0;
		int start = 0;
		int end=0;
		for(int i=0;i<A.size();i++){
			if(A.get(i)==0){				
				ones = 0;
				start = i+1;
			}
			else{
				ones++;
				
				if(ones>numOfOnes){
					end = i;
					lastStart = start;
				}
				numOfOnes = Math.max(numOfOnes, ones);
			}
		}
		//System.out.println(lastStart+"\t"+end);
		res.add(numOfOnes);
		res.add(lastStart);
		res.add(end);
		return res;
	}
	
	//from ib
	static public ArrayList<Integer> maxoneOptimised(ArrayList<Integer> A, int B) {
        int index = 0, count = 0;
        int left = 0, right = 0;
        int flips = B;

        while (right < A.size()) {
            if (A.get(right) == 1) {
                right++;
            } else if (flips > 0) { // A.get(right) == 0
                right++;
                flips--;
            } else if (left < right) { // A.get(right) == 0 && flips == 0
                flips += 1 - A.get(left);
                left++;
            } else { // A.get(right) == 0 && flips == 0 && left == right
                left++; right++;
            }

            if (right - left > count) {
                index = left;
                count = right - left;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < count; i++)
            result.add(index + i);
        return result;
    }
	
	public static void main(String[] args) {
		
		System.out.println(maxoneOptimised(new ArrayList<Integer>(Arrays.asList(1,1,0)), 2));
		//System.out.println(numOfContiguousOnes(new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,0,0,1,1))));
	}

}
