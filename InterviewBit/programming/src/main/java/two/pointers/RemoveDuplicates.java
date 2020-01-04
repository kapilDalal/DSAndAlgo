package two.pointers;

import java.util.ArrayList;

public class RemoveDuplicates {
	
	public int removeDuplicates(ArrayList<Integer> a) {
        int sp=0;       
        for(int fp=0;fp<a.size()-1;fp++){
            if(a.get(fp)!=a.get(fp+1)){
                sp++;
                a.set(sp,a.get(fp+1));
            }
        }
        sp++;
        
        for(int i=a.size()-1;i>=sp;i--)
        	a.remove(i);
       
        return sp;
    }
	
	public static void main(String[] args) {
		//RemoveDuplicates rd = new RemoveDuplicates();
		//rd.removeDuplicates(Arrays.asList(5000,5000,5000));
	}

}
