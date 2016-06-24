package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cdlvsheng on 2016/4/11.
 */
public class MyHandler implements InvocationHandler {

	private Object target;

	/**
	 * 绑定委托对象并返回一个代理类
	 *
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke start");
		Object o = method.invoke(target, args);
		System.out.println("invoke end");
		return o;
	}
}
