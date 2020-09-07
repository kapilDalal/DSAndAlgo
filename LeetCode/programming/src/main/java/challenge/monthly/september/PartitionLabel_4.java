package challenge.monthly.september;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabel_4 {

    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        for(int i=0;i<S.length();i++){
            if(!common(start,i, S)){
                res.add(i-start+1);
                start=i+1;
            }
        }
        //res.add(S.length()-start);
        return res;
    }

    private boolean common(int start1, int end1,String s) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for(int i=start1;i<=end1;i++)
            set1.add(s.charAt(i));
        for(int i=end1+1;i<s.length();i++)
            set2.add(s.charAt(i));
        set1.retainAll(set2);
        if(set1.size()>0)
            return true;
        return false;
    }


    public List<Integer> partitionLabelsOptimized(String S) {
        int n = S.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for(int i=0; i<n; i++) count[S.charAt(i)-'a'] =i;
        int start = 0;
        while(start < n){
            int end = getlastIndex(count, S, start);
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
    public int getlastIndex(int[] count, String s, int start){
        int max = count[s.charAt(start)-'a'];
        int pos = start;
        while(pos < max){
            max = Math.max(max, count[s.charAt(pos)-'a'] );
            pos++;
        }
        return max;
    }

    public static void main(String[] args) {
        PartitionLabel_4 pl = new PartitionLabel_4();
        System.out.println(pl.partitionLabels("abcdefga"));
    }

}
