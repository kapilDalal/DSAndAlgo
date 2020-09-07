package challenge.weekly.september6;

public class MinDeletionCost {

    public static int minCost(String s, int[] cost) {
        int i=0;
        int c = 0;
        int next = i+1;
        while(i<s.length()-1 && next<s.length()){

            if(s.charAt(i)!=s.charAt(next)) {
                i=next;
                next++;
                continue;
            }
            if(cost[i]<cost[next]){
                c += cost[i];
                i=next;
                next++;
            }
            else{
                c += cost[next];
                next++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(minCost("aaaaaa",new int[]{2,1,1,0,3,4}));
    }

}
