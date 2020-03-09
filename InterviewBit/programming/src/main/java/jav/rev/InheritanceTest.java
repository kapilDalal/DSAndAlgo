package jav.rev;

abstract class Parent{
	public int kapil=1;
	public void who(){
		System.out.println("I am the parent");
	}
}


public class InheritanceTest extends Parent implements Parent1{

	public int kapil=2;
	public void who(){
		System.out.println("I am the child");
	}
	public void cheldSpecific(){
		System.out.println("i am only defined in child");
	}
	public static void main(String[] args) {
		InheritanceTest p = new InheritanceTest();
		p.who();
		System.out.println(p.kapil);
		
		/*InheritanceTest c = (InheritanceTest) new Parent();
		c.who();*/
		
	}
}