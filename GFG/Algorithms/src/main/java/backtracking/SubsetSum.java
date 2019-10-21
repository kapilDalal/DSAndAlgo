package backtracking;

public class SubsetSum {
	
	static void subsetSum(Integer[] set,Integer[] subset,int sumSoFar,int start,int endOfSubset,int target){
		
		if(sumSoFar==target){
			print(subset,endOfSubset);
			subsetSum(set, subset, sumSoFar-subset[endOfSubset-1], start+1, endOfSubset-1, target);
		}
		else{
			
			for(int i=start;i<set.length;i++){
				if(sumSoFar+set[i]<=target){
					subset[endOfSubset] = set[i];
					subsetSum(set, subset, sumSoFar+set[i], i+1, endOfSubset+1, target);
				}
			}
			
		}
		
	}

	private static void print(Integer[] subset, int endOfSubset) {
		for(int i=0;i<endOfSubset;i++)
			System.out.print(subset[i]+"\t");
		System.out.println();
		
	}
	
	static void printSubsetsWithSum(Integer[] set,int target){
		Integer[] subset = new Integer[set.length];
		subsetSum(set, subset, 0, 0, 0, target);
	}
	
	public static void main(String[] args) {
		Integer[] set = {10,7,18,12,20,25};
		printSubsetsWithSum(set, 25);
		
	}

}
