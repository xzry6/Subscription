package subscription.test;

import java.util.concurrent.TimeUnit;

import subscription.MesQue;
import subscription.Subscriber;

public class SubscriberTester extends Subscriber implements Runnable{
	
	private MesQue queue;
	private String id;
	
	public SubscriberTester(MesQue queue, String id) {
		this.queue = queue;
		this.id = id;
	}
	
	public void run() {
		boolean bool = false;
		while(true) {
			if(terminate()) {
				if(!bool) bool = true;
				else break;
			} else {
				bool = false;
				int count = subscribe(queue);
				if(count != 0) 
					System.out.println(count+" messages has been retrieved by "+id);
			}
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	private boolean terminate() {
		if(map.containsKey(queue)) {
			int num = queue.getCount();
//			System.out.println(num+" "+map.get(queue).size());
			if(map.get(queue).size() == num)
				return true;
		}
		return false;
	}
}
