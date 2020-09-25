package jav.rev.threads;

public class AddOneAndTwoUsingTwoThreads {

	private volatile int i = 0;
	private boolean secondThreadTurn = false;
	private boolean firstThreadTurn = true;
	

	public void addFirstThread() throws InterruptedException {
		synchronized (this) {
			while (!firstThreadTurn) {
				wait();
			}
			if(i<10) {
				i = i + 1;
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
			firstThreadTurn = false;
			secondThreadTurn = true;
			notify();
		}
		
	}

	public void addSecondThread() throws InterruptedException {
		
		synchronized (this) {
			while (!secondThreadTurn) {
				wait();
			}
			if(i<10) {
				i = i + 1;
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
			firstThreadTurn = true;
			secondThreadTurn = false;
			notify();
		}
		
	}

	public  int getI() {
		return i;
	}

	public static void main(String[] args) {
		AddOneAndTwoUsingTwoThreads a = new AddOneAndTwoUsingTwoThreads();
		Thread t1 = new Thread(() -> {
			
				while (a.getI() < 10){
					try {
						a.addFirstThread();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		});
		Thread t2 = new Thread(() -> {
			
				while (a.getI() < 10){
					try {
						a.addSecondThread();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			
		});

		t1.start();
		t2.start();
	}

}
