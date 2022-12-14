package com.sda.advanced.concurrency.deadlock.solution;

import com.sda.advanced.concurrency.deadlock.problem.A;
import com.sda.advanced.concurrency.deadlock.problem.B;

public class DemoDeadLockSolution {

    public static void main(String[] args) {

        DemoDeadLockSolution test = new DemoDeadLockSolution();

        final A a = new A();
        final B b = new B();

        // Thread-1
        Runnable block1 = () -> {
            synchronized (b) {
                try {
                    // Adding delay so that both threads can start trying to
                    // lock resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread-1 have A but need B also
                synchronized (a) {
                    System.out.println("In block 1");
                }
            }
        };

        // Thread-2
        Runnable block2 = () -> {
            synchronized (b) {
                // Thread-2 have B but need A also
                synchronized (a) {
                    System.out.println("In block 2");
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}
