package threads.callinorder;

public class Second extends Thread{
    private Foo foo;
    public Second(Foo foo){
        this.foo = foo;
    }
    public void run(){
        try {
            foo.f.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foo.f.release();

        System.out.println("second called");

        foo.s.release();
    }

}
