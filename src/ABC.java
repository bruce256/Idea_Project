/**
 * Created by cdlvsheng on 2016/3/26.
 */
public class ABC {
	public static void main(String[] args) {
		while (true) {

			try {
				A a = new A();
				B b = new B();
				C c = new C();
				System.out.println(a.getState());
				a.start();
				System.out.println(a.getState());
				a.join();
				System.out.println(a.getState());
				b.start();
				b.join();
				c.start();
				c.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class A extends Thread {
	@Override
	public void run() {
		System.out.println("A");
	}
}


class B extends Thread {
	@Override
	public void run() {
		System.out.println("B");
	}
}


class C extends Thread {
	@Override
	public void run() {
		System.out.println("C");
	}
}
