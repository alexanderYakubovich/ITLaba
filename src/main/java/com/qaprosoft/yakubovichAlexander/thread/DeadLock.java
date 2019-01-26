package com.qaprosoft.yakubovichAlexander.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DeadLock {
    private final static Logger LOGGER = LogManager.getLogger(DeadLock.class);

    public static void main(String[] args) {
	Lock lock1 = new ReentrantLock();
	ThreadOne thread = new ThreadOne(lock1);
	thread.start();

    }
}