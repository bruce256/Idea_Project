package reflect;

/**
 * Created by cdlvsheng on 2016/4/10.
 */
public class CalculatorImpl implements Calculator{
/*
	private int a;

	public CalculatorImpl() {
	}

	public CalculatorImpl(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public CalculatorImpl setA(int a) {
		this.a = a;
		return this;
	}

	public int getB() {
		return b;
	}

	public CalculatorImpl setB(int b) {
		this.b = b;
		return this;
	}
	private int a;

	public CalculatorImpl() {
	}

	public CalculatorImpl(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public CalculatorImpl setA(int a) {
		this.a = a;
		return this;
	}

	public int getB() {
		return b;
	}

	public CalculatorImpl setB(int b) {
		this.b = b;
		return this;
	}

	private int b;*/

	@Override
	public int add(int a, int b) {
		int result = a + b;
		System.out.println(String.format("%d + %d = %d", a, b, result));
		return result;
	}
}
