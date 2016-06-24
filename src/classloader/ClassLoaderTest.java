package classloader;

import concurrent.LockTest;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cdlvsheng on 2016/4/1.
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {

		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String      fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is       = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};

		LockTest   obj1 =  new LockTest();
		LockTest obj  = (LockTest) myLoader.loadClass("concurrent.LockTest").newInstance();


		System.out.println(obj);
		System.out.println(obj instanceof concurrent.LockTest);
		System.out.println(obj1 instanceof concurrent.LockTest);
		System.out.println(obj.equals(obj1));
	}
}
