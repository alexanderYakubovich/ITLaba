package com.qaprosoft.yakubovichAlexander.thread;

import java.util.concurrent.locks.Lock;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ThreadTwo extends Thread {

    private final static Logger LOGGER = LogManager.getLogger(ThreadTwo.class);

    private Lock lock1;

    ThreadOne t1 = new ThreadOne(lock1);

    public void run() {
	lock1.lock();
	try {
	    sleep(500);
	} catch (InterruptedException e) {
	    LOGGER.info(e);
	}
	LOGGER.info("Thread-2 lock2");
	try {
	    sleep(500);
	} catch (InterruptedException e) {
	    LOGGER.info(e);
	}
	t1.run();
	lock1.unlock();
    }
}
