package jav.rev.threads;

public class PrintSequenceRemainderApproach implements Runnable{

	public int PRINT_NUMBERS_UPTO=10;
	static int  number=1;
	int remainder;
	static Object lock=new Object();
 
	PrintSequenceRemainderApproach(int remainder)
	{
		this.remainder=remainder;
	}
 
	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO-1) {
			synchronized (lock) {
				while (number % 3 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
	public static void main(String[] args) {
		
		PrintSequenceRemainderApproach r1 = new PrintSequenceRemainderApproach(0);
		PrintSequenceRemainderApproach r2 = new PrintSequenceRemainderApproach(1);
		PrintSequenceRemainderApproach r3 = new PrintSequenceRemainderApproach(2);
		
		Thread t1=new Thread(r1,"T1");
		Thread t2=new Thread(r2,"T2");
		Thread t3=new Thread(r3,"T3");
		
		t1.start();
		t2.start();
		t3.start();	  
		
	}

}
