package com.bwf.thread;
/**
 * 实现Runable接口
 * @author Administrator
 *
 */
public class ThreadDemo03 {

	public static void main(String[] args ) {
		MyRunable myRunable = new MyRunable();
		new Thread(myRunable,"runable1").start();
		new Thread(myRunable,"runable2").start();
		new Thread(myRunable,"runable3").start();
		/**
		 * 一个Runable对象可以被多个Thread对象所使用;可以共享参数
		 */
	}
	
}

/**1、写一个类实现Runable接口
 * 2、重写run方法
 * 3、通过new Thread(runable)创建一个线程，并且通过start()方法启动 
 * @author Administrator
 *
 */
class MyRunable implements Runnable{

	private int count = 100;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"剩下的票数："+count);
		count--;
	}
	
}
