package recursionanddynamicprogramming;

import java.util.ArrayList;

public class PowerSet {

    public void allSubsets(int[] a, int i, ArrayList<Integer> l){
        if(i==a.length) {
            System.out.println(l);
            return;
        }
        l.add(a[i]);
        allSubsets(a,i+1,l);
        l.remove(l.size()-1);
        allSubsets(a,i+1,l);
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        ps.allSubsets(new int[]{1,2,3},0,new ArrayList<>());
    }
}
