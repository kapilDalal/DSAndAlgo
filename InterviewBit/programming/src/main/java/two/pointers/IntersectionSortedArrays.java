package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionSortedArrays {
	
	static public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int a = 0;
        int b = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(a<A.size() && b<B.size()){
            if(A.get(a).intValue()==B.get(b).intValue()){
                res.add(A.get(a));
                a++;
                b++;
            }
            else if(A.get(a).intValue()<B.get(b).intValue()){
                a++;
            }
            else{
                b++;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(intersect(Arrays.asList(1,2,3,3,4,5,6), Arrays.asList(3,5)));
	}

}
