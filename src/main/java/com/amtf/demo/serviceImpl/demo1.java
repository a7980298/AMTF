package com.amtf.demo.serviceImpl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {
	
	public static void main(String[] args) {
		text1 text1=new text1();
//		for (int i = 0; i < 10; i++) {
//			Thread thread = new Thread(text1, "thread" + i);
//			thread.start();
//		}
		Thread thread1 = new Thread(text1);
		Thread thread2 = new Thread(text1);
		Thread thread3 = new Thread(text1);
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
class text1 implements Runnable{

	private int i;
	private static final Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		lock.lock();
		System.out.println(++i);
		lock.unlock();
	}
}
