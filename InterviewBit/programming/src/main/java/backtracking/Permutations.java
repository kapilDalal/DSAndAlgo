package backtracking;

import java.util.ArrayList;

public class Permutations {
	
	ArrayList<ArrayList<Integer>> result;
	Permutations(){
        result = new ArrayList<>();
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        permuteUtil(A,0,A.size());
        return result;
    }
    
    void permuteUtil(ArrayList<Integer> A, int l, int r){
        if(l==r){
            result.add(new ArrayList<Integer>(A));
        }
        for(int i=l;i<r;i++){
            swap(A,l,i);
            permuteUtil(A,l+1,r);
            swap(A,l,i);
        }
    }
    
    void swap(ArrayList<Integer> A, int l, int r){
        int temp = A.get(l);
        A.set(l,A.get(r));
        A.set(r,temp);
    }
	public static void main(String[] args) {
		//permute(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		
	}

}
