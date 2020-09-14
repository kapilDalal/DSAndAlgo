package threads.fizzbuzz;

public class NumberIncrementer extends Thread{

    int end;
    int num;

    public NumberIncrementer(int end){
        this.num = 1;
        this.end = end;
    }


    public void run() {
        while(num <=end) {
            synchronized (this) {

                while ((num%3 == 0 || num%5 == 0) && num<=end) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                this.notifyAll();
            }
        }
    }

}
