package subscription;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Subscriber{
	
	protected Map<MesQue, HashSet<Integer>> map = new HashMap<MesQue, HashSet<Integer>>();
	
	public int subscribe(MesQue queue) {
		if(!map.containsKey(queue)) {
			map.put(queue, new HashSet<Integer>());
			return 0;
		}
		HashSet<Integer> set = map.get(queue);
		
		int count = 0;
		for(int i=1; i<=queue.getCount(); ++i) {
			if(set.contains(i)) 
				continue;
//			System.out.println(i+": ["+queue.getTime(i)+"] "+queue.getMessage(i));
			set.add(i);
			count++;
		}
		return count;
	}
}
