package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cdlvsheng on 2016/3/31.
 */
public class LockTest {
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LockTest lockTest = (LockTest) o;

		return a == lockTest.a;

	}

	@Override
	public int hashCode() {
		return a;
	}

	private int a = 0;
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
	}
}
