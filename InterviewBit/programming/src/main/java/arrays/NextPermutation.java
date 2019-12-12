package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
	static public List<Integer> nextPermutation(List<Integer> A) {
		boolean nextPermutaionFound = false;
        int size=1;
        while(size<=A.size()){
        	List<Integer> subList = A.subList(A.size()-size, A.size());
            for(int i=subList.size()-1;i>0;i--){
                int ele = subList.get(i);
                int j;
                for(j=i-1;j>=0;j--){
                    if(ele>subList.get(j)){
                        subList.set(i,subList.get(j));
                        subList.set(j,ele);
                        nextPermutaionFound=true;
                        break;
                    }
                    
                }
                if(nextPermutaionFound){                                 	
                	Collections.sort(subList.subList(j+1, subList.size()));
                	break;
                }
            }
            if(nextPermutaionFound)
                break;
            size++;
        }
        if(nextPermutaionFound==false){
            Collections.sort(A);
        }
        return A;
    }
	
	public static void main(String[] args) {
		//List<Integer> A = Arrays.asList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52);
		List<Integer> A = Arrays.asList(626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506, 59, 854, 422);
		System.out.println(nextPermutation(A));
		
	}
}
