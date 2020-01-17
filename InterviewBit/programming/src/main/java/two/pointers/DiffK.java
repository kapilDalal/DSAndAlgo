package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffK {
	
	static public int diffPossible(ArrayList<Integer> A, int B) {
		
		
		int i=0;
        int j=1;
        while(j<A.size() && i<A.size()){
            
            int diff=(A.get(j)-A.get(i));
            if(diff==B && i!=j)
            return 1;
            if((A.get(j)-A.get(i)) <B)
            j++;
            else i++;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(diffPossible(new ArrayList<Integer>(Arrays.asList(0, 1, 9, 10, 13, 17, 17, 17, 23, 25, 29, 30, 37, 38, 39, 39, 40, 41, 42, 60, 64, 70, 70, 70, 72, 75, 85, 85, 90, 91, 91, 93, 95)), 83));
	}

}
