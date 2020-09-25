package jav.rev.threads;

public class OddEvenLock {

	boolean isOdd = true;
	boolean signal = false;
	boolean firstOperationDone = false;
	public synchronized void waitOdd() throws InterruptedException {
		while(!isOdd) {
			this.wait();
		}
		isOdd = false;
		this.notifyAll();
	}
	public synchronized  void waitEven() throws InterruptedException {

		while (isOdd) {
			this.wait();
		}
		isOdd = true;
		this.notifyAll();
	}
	
}
