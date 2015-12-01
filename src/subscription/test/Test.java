package subscription.test;

import subscription.MesQue;

public class Test {
	
	public static void main(String[] args) {
		MesQue queue = new MesQue();
		Thread t1 = new Thread(new PublisherTester(queue, "p1", 50));
		Thread t2 = new Thread(new PublisherTester(queue, "p2", 30));
		Thread t3 = new Thread(new SubscriberTester(queue, "s1"));
		t1.start();
		t2.start();
		t3.start();
	}
}
