package com.qaprosoft.yakubovichAlexander.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ThreadOne extends Thread {

    private final static Logger LOGGER = LogManager.getLogger(ThreadOne.class);

    private Lock lock1 = new ReentrantLock();

    public ThreadOne(Lock lock1) {
	this.lock1 = lock1;
    }

    ThreadTwo t2 = new ThreadTwo();

    public void run() {
	lock1.lock();

	try {
	    sleep(500);
	} catch (InterruptedException e) {
	    LOGGER.info(e);
	}
	LOGGER.info("Thread-1 lock1");
	try {
	    sleep(500);
	} catch (InterruptedException e) {
	    LOGGER.info(e);
	}
	t2.run();

	lock1.unlock();
    }

}