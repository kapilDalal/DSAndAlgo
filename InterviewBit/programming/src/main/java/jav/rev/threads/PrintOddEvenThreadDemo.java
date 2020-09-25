package jav.rev.threads;

public class PrintOddEvenThreadDemo {

	public static void main(String[] args) {

		OddEvenLock lock = new OddEvenLock();
		Thread odd = new Thread(() -> {			
			synchronized (lock) {
				int i = 1;
				while(i<=10) {
					try {
						lock.waitOdd();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i);
					i+=2;
				}				
			}			
		});
		Thread even = new Thread(() -> {			
			synchronized (lock) {
				int i = 2;
				while(i<=10) {
						try {
							lock.waitEven();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(i);
						i+=2;
				}
			}
		});
		odd.start();
		even.start();

	}
}
