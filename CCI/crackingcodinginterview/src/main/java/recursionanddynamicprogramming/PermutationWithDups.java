package recursionanddynamicprogramming;

import java.util.Arrays;

public class PermutationWithDups {

    private static void permutUtil(String remaining, String prefix){
        if(remaining.length()==0)
            System.out.println(prefix);
        for(int i=0;i<remaining.length();i++){
            if(i>0 && remaining.charAt(i)==remaining.charAt(i-1))
                continue;
            prefix += remaining.charAt(i);
            permutUtil(remaining.substring(0,i)+remaining.substring(i+1),prefix);
            prefix = prefix.substring(0,prefix.length()-1);
        }
    }
    public static void permut(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        str = new String(arr);
        permutUtil(str,"");
    }

    public static void main(String[] args) {
        permut("aab");
    }
}
