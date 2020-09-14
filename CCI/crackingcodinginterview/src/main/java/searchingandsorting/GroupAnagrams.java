package searchingandsorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagrams {

    Comparator<String> myComp = new Comparator<String>()
    {
        @Override
        public int compare(String a, String b)
        {
            for(int i = 0;
                i < Math.min(a.length(),
                        b.length()); i++)
            {
                if (a.charAt(i) ==
                        b.charAt(i))
                {
                    continue;
                }
                else if(a.charAt(i) >
                        b.charAt(i))
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            return 0;
        }
    };


    public static void main(String[] args) {
        String[] arr = {"az","dbc","ab","acb","ade","cfh","cba"};
        GroupAnagrams ga = new GroupAnagrams();
        Arrays.sort(arr,ga.myComp);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"\t");
    }

}
