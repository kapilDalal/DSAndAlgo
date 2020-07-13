package jav.rev;

public class C implements A, B{

	
	public static void main(String[] args) {
		C c = new C();
		A a = c;
		B b = c;
		a.saySomething();
		b.saySomethingB();
	}

}
