package concurrent;

/**
 * Created by cdlvsheng on 2016/3/28.
 */
public class WaitNotify {
	public static Object object = new Object();
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();

		thread1.start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread2.start();
	}

	static class Thread1 extends Thread{
		@Override
		public void run() {
			synchronized (object) {
				try {
					object.wait();
				} catch (InterruptedException e) {
				}
				System.out.println("线程"+ this.getClass().getName()+"获取到了锁");
			}
		}
	}

	static class Thread2 extends Thread{
		@Override
		public void run() {
			synchronized (object) {
				object.notify();
				System.out.println("线程"+ this.getClass().getName()+"调用了object.notify()");
			}
			System.out.println("线程"+ this.getClass().getName()+"释放了锁");
		}
	}
}