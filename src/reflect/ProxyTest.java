package reflect;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cdlvsheng on 2016/4/11.
 */
public class ProxyTest {
	public static void main(String[] args) {
		//System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		MyHandler  ih = new MyHandler();
		Calculator c  = (Calculator) ih.bind(new CalculatorImpl());
		c.add(3, 5);
		System.out.println("hashcode: " + c.hashCode());
		Map<Integer, Integer> map = (Map<Integer, Integer>) ih.bind(new HashMap<Integer, Integer>());
		map.put(1, 1);
		System.out.println(map.size());
		Map<Integer, Integer> m = (Map<Integer, Integer>) ih.bind(new TreeMap<Integer, Integer>());
		map.put(1, 1);
		System.out.println(map.size());
	}
}
