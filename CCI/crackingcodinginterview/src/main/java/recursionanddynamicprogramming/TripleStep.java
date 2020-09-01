package recursionanddynamicprogramming;

public class TripleStep {

    int cnt = 0;
    public void getCount(int step, int n){
        if(step>n)
            return;
        if(step==n)
            cnt++;
        for(int i=1;i<=3;i++){
            getCount(step+i,n);
        }
    }
    public int countTheStepsRec(int n){
        this.cnt = 0;
        getCount(0,n);
        return cnt;
    }

    public int countTheStepsOptimised(int n){
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int d = -1;
        for(int i=4;i<=n;i++){
            d = a+b+c;
            a = b;
            b = c;
            c = d;

        }

        return d;
    }

    public static void main(String[] args) {
        TripleStep ts = new TripleStep();
        for(int i=1;i<=10;i++) {
            System.out.println(ts.countTheStepsRec(i));
            System.out.println(ts.countTheStepsOptimised(i));
        }
    }




}
