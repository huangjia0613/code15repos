package com.bwf.thread.sync;

import org.apache.tomcat.jni.Thread;

/**
 * 线程的同步
 * 同步的：StringBuffer、Vector、hashtable、Enumration、Collections、synchronizedXX
 * @author Administrator
 *
 */
public class Thread_Sync {

	public static void main(String[] args) {
		
		MyTRunable runable = new MyTRunable();
		new Thread().notify();
        new Thread().notify();
        new Thread().toString();
	}

}

/**
 * 线程同步有两种方式：（1）同步代码块  （2）同步方法  synchronized 加上了锁，同步锁
 * @author Administrator
 *
 */
class MyTRunable implements Runnable{
	
	private int count = 100;

	@Override
	public void run() {
		//同步代码块
//		synchronized (this) {
//			count--;
//			System.out.println("剩余票数：" + count);
//		}
		sellTickets();
		
	}
	
	/**
	 * 卖票，这里只解决了并发问题，并不能解决卖完一张票后就让下一个窗口卖
	 */
	public synchronized void sellTickets() {
		for(int i = 0;i<count;i++){
			System.out.println(Thread.current()+ "卖了票号为：" +(i+1));
		}
	}
	
}
