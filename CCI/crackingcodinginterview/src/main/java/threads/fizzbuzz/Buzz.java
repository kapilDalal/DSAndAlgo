package threads.fizzbuzz;

public class Buzz extends Thread{

    NumberIncrementer incrementer;

    public Buzz(NumberIncrementer incrementer){

        this.incrementer = incrementer;
    }


    public void run(){

        while(incrementer.num<=incrementer.end) {
            synchronized (incrementer) {


                while (incrementer.num % 15 == 0  || incrementer.num % 5 != 0 && incrementer.num<=incrementer.end) {

                    try {
                        incrementer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                if(incrementer.num<=incrementer.end)
                    System.out.println("num is "+incrementer.num+" so printing buzz");
                incrementer.num++;
                incrementer.notifyAll();
            }
        }

    }
}
