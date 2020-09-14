package challenge.monthly.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3_12 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        getCombinations(k,n,1,0,new ArrayList<Integer>(),res);


        return res;
    }

    private void getCombinations(int targetSize, int targetSum,int num,int sum, ArrayList<Integer> list, List<List<Integer>> res) {
        if(list.size()>targetSize || sum>targetSum)
            return;
        if(sum==targetSum && targetSize==list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=num;i<10;i++)
        {
            if(sum+i<=targetSum) {
                list.add(i);
                getCombinations(targetSize, targetSum, i + 1, sum + i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3_12 cs = new CombinationSum3_12();
        System.out.println(cs.combinationSum3(1,9));
    }
}
