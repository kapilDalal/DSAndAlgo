package challenge.weekly.September20;

import java.util.ArrayList;

public class MaxUniqueSubstrings {
    static int max = 0;
    public void maxUniqueSplitUtil(String s, ArrayList<String> set) {

        if(s.length()==0){
            max = Math.max(max,set.size());
        }

        for(int i=0;i<=s.length();i++){
            String sub = s.substring(0,i);
            if(sub.length()>0 && !set.contains(sub)){
                set.add(sub);
                maxUniqueSplitUtil(s.substring(i,s.length()),set);
                set.remove(set.size()-1);
            }
        }

    }
    public int maxUniqueSplit(String s) {
        max = 0;
        maxUniqueSplitUtil(s,new ArrayList<>());
        return max;
    }


    public static void main(String[] args) {
        MaxUniqueSubstrings mu = new MaxUniqueSubstrings();
        mu.maxUniqueSplitUtil("a",new ArrayList<>());
        System.out.println(max);
    }


}
