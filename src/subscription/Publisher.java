package subscription;

public class Publisher{

	public void publish(MesQue queue, String mes) {
		queue.retrieve(mes);
	}
	
}
