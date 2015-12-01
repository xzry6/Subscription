package subscription.test;

import subscription.MesQue;
import subscription.Publisher;

public class PublisherTester extends Publisher implements Runnable {

	private MesQue queue;
	private String id;
	private int messageNumber;
	
	public PublisherTester(MesQue queue, String id, int messageNumber) {
		this.queue = queue;
		this.id = id;
		this.messageNumber = messageNumber;
	}

	public void run() {
		for(int i=1; i<=messageNumber; ++i) {
			try {
				Thread.sleep(100);
				publish(queue, id+" publishes "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
