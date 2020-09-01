package recursionanddynamicprogramming;

public class PermutationWithoutDups {

    public static void permut(String remaining,String prefix){
        if(remaining.length()==0)
            System.out.println(prefix);
        for(int i=0;i<remaining.length();i++){
            prefix += remaining.charAt(i);
            permut(remaining.substring(0,i)+remaining.substring(i+1),prefix);
            prefix = prefix.substring(0,prefix.length()-1);
        }
    }


    public static void main(String[] args) {
        permut("abc","");
    }

}
