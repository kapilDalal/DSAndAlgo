package threads.fizzbuzz;

public class FizzBuzz extends Thread{

    private NumberIncrementer incrementer;

    public FizzBuzz(NumberIncrementer incrementer){

        this.incrementer = incrementer;
    }

    @Override
    public void run() {

        while(incrementer.num<=incrementer.end){
                synchronized (incrementer){

                    while(incrementer.num%15!=0 && incrementer.num<=incrementer.end){
                        try {
                            incrementer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(incrementer.num<=incrementer.end)
                        System.out.println("num is "+incrementer.num+" so printing fizzbuzz");
                    incrementer.num++;
                    incrementer.notifyAll();
                }
        }


    }

}
