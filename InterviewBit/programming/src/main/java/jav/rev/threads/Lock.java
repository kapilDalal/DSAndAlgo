package jav.rev.threads;

public class Lock {
	
	private boolean isLocked      = false;
	private Thread  lockingThread = null;

	
	/*
	 * synchronized blocks makes no guarantees about what thread is being granted
	 * access if more than one thread is waiting to enter. Nor does wait() make any
	 * guarantees about what thread is awakened when notify() is called. So, the
	 * current version of the Lock class makes no different guarantees with respect
	 * to fairness than synchronized version of doSynchronized(). But we can change
	 * that.
	 */
	  public synchronized void lock() throws InterruptedException{
	    while(isLocked){
	      wait();
	    }
	    isLocked      = true;
	    lockingThread = Thread.currentThread();
	  }

	  public synchronized void unlock(){
	    if(this.lockingThread != Thread.currentThread()){
	      throw new IllegalMonitorStateException(
	        "Calling thread has not locked this lock");
	    }
	    isLocked      = false;
	    lockingThread = null;
	    notify();
	  }
	  public static void main(String[] args) {
		
	}

}
