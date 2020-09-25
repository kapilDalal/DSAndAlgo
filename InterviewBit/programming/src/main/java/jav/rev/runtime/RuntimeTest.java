package jav.rev.runtime;

import java.io.IOException;

/*
* Every Java application has a single instance of class Runtime
* that allows the application to interface with the environment in which the application is running.
* */
public class RuntimeTest {

    public static void main(String[] args) throws IOException {
        Runtime run = Runtime.getRuntime();
        System.out.println(run.availableProcessors());
        System.out.println(run.maxMemory());
        System.out.println(run.totalMemory());
        System.out.println(run.freeMemory());
        run.exec("C:\\Program Files\\Notepad++\\notepad++.exe");
    }

}
