package subscription;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MesQue {
	
	private int count = 0;
	private Map<Integer, String> message = new HashMap<Integer, String>();
	private Map<Integer, Date> date = new HashMap<Integer, Date>();
	
	public synchronized void retrieve(String mes) {
		date.put(++count, new Date());
		message.put(count, mes);
//		System.out.println(count);
	}
	
	public String getMessage(int i) {
		return message.get(i);
	}
	
	public Date getTime(int i) {
		return date.get(i);
	}
	
	public int getCount() {
		return count;
	}
}
