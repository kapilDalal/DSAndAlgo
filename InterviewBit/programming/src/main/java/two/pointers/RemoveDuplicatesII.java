package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesII {
	
	
	public int removeDuplicates(ArrayList<Integer> a) {
		if(a.size()<=2)
			return a.size();
		int ele = a.get(a.size()-1);
		int cnt = 1;
		for(int i=a.size()-2;i>=0;i--){
			if(ele!=a.get(i)){
				ele = a.get(i);
				cnt=1;
			}
			else{
				cnt++;
				if(cnt>=3){
					a.remove(i);
				}
			}
				
		}	
		//System.out.println(a);
		return a.size();
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesII rd = new RemoveDuplicatesII();
		rd.removeDuplicates(new ArrayList<Integer>(Arrays.asList(1,1,1,2,2,3,4,4,4,4)));
	}

}
