package com.qaprosoft.yakubovichAlexander.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    public static void main(String[] args) {
	Lock lock1 = new ReentrantLock();
	ThreadOne thread = new ThreadOne(lock1);
	thread.start();

    }
}