package jav.rev.runtime;
/*
Shutdown Hooks are a special construct that allows developers to plug in a piece of code
to be executed when the JVM is shutting down. This comes in handy in cases where we need
to do special clean up operations in case the VM is shutting down.

Handling this using the general constructs such as making sure that we call a special procedure
before the application exits (calling System.exit(0) ) will not work for situations where the
VM is shutting down due to an external reason (ex. kill request from O/S), or due to a resource
problem (out of memory). As we will see soon, shutdown hooks solve this problem easily,
by allowing us to provide an arbitrary code block, which will be called by the JVM when it is
shutting down.

more info - https://www.geeksforgeeks.org/jvm-shutdown-hook-java/
* */
public class ShutdownhookTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(){
            public void run(){
                System.out.println("shutdown hook called");
            }
        });
        System.out.println("exiting..");
    }
}
