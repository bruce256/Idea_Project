package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by cdlvsheng on 2016/4/10.
 */
public class ReflectTest {

	public static void main(String[] args) {
		Class c = CalculatorImpl.class;
		try {
			CalculatorImpl cal = (CalculatorImpl) c.newInstance();
			//System.out.println(cal.getA() + "\t" + cal.getB());
			Field[] fields = c.getDeclaredFields();
			for(Field f : fields) {
				System.out.println(f.getName());
			}

			Method[] methods = c.getMethods();
			for (Method m: methods) {
				System.out.println(m.getName());
			}

			Method add = c.getDeclaredMethod("add", int.class, int.class);
			Object o = add.invoke(cal, 4, 6);
			System.out.println(o);
			System.out.println(int.class);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
