package jav.rev.threads;

public class PrintSequenceUsingThreeThreadsDumbApproach {
	
	int start;
	boolean firstThreadTurn = true;
	boolean secondThreadTurn = false;
	boolean thirdThreadTurn = false;
	int max;
	public PrintSequenceUsingThreeThreadsDumbApproach(int start,int max) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.max = max;
	}
	
	public void incFirstThread() throws InterruptedException {
		while(!firstThreadTurn) {
			this.wait();
		}
		if(start<max) {
			start++;
			System.out.println(Thread.currentThread().getName()+ " "+start);
		}
		firstThreadTurn = false;
		secondThreadTurn = true;
		thirdThreadTurn = false;
		this.notifyAll();
	}
	public void incSecThread() throws InterruptedException {
		while(!secondThreadTurn) {
			this.wait();
		}
		if(start<max) {
			start++;
			System.out.println(Thread.currentThread().getName()+ " "+start);
		}		
		secondThreadTurn = false;
		firstThreadTurn = false;
		thirdThreadTurn = true;
		this.notifyAll();
	}
	public void incThirdThread() throws InterruptedException {
		while(!thirdThreadTurn) {
			this.wait();
		}
		if(start<max) {
			start++;
			System.out.println(Thread.currentThread().getName()+ " "+start);
		}		
		secondThreadTurn = false;
		firstThreadTurn = true;
		thirdThreadTurn = false;
		this.notifyAll();
	}
	public static void main(String[] args) {
		PrintSequenceUsingThreeThreadsDumbApproach seq = new PrintSequenceUsingThreeThreadsDumbApproach(0,10);
		Thread t1 = new Thread(()->  {
			synchronized (seq) {
				while(seq.start<seq.max) {
					try {
						seq.incFirstThread();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(()->  {
			synchronized (seq) {
				while(seq.start<seq.max) {
					try {
						seq.incSecThread();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t3 = new Thread(()->  {
			synchronized (seq) {
				while(seq.start<seq.max) {
					try {
						seq.incThirdThread();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}

}
