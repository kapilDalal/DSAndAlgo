package threads.callinorder;

public class Third extends Thread{

    private Foo foo;
    public Third(Foo foo){
        this.foo = foo;
    }
    public void run(){
        try {
            foo.s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foo.s.release();
        System.out.println("third called");
    }
}
