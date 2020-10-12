package challenge.weekly.October11;

public class MaxDepth {

    public int maxDepth(String s) {
        int md = 0;
        int curr =0;
        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
            if(ch=='('){
                curr++;
            }else if(ch==')')
                curr--;
            md = Math.max(curr,md);

        }

        return md;
    }

    public static void main(String[] args) {
        String s = "8*((1*(5+6))*(8/6))";
        MaxDepth md = new MaxDepth();
        System.out.println(md.maxDepth(s));
    }

}
