import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		ThreadA a  = new ThreadA();
		Thread  t1 = new Thread(a);

		ThreadB b  = new ThreadB();
		Thread  t2 = new Thread(b);

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class ThreadA implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getClass().getName() + " end!");
	}
}

class ThreadB implements Runnable {

	@Override
	public void run() {
		System.out.println(this.getClass().getName() + " end!");
	}
}