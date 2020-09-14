package threads.callinorder;

public class First extends Thread{
    private Foo foo;
    public First(Foo foo){
        this.foo = foo;
    }
    public void run(){

        System.out.println("first called");
        foo.f.release();
    }

}
