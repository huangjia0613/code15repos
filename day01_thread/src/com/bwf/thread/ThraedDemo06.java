package com.bwf.thread;

public class ThraedDemo06 {

	/**
	 * 默认都会有一个主线程，GC线程
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunable2());
		t.setName("线程1");
//		t.start();
//		System.out.println("线程名称为：" + t.getName());
		//Thread.currentThread()哪个线程跑着的，或者在那个线程中，调用的就是那个线程
		System.out.println("线程名称为：" + Thread.currentThread().getName());
		
		System.out.println("线程是否在运行：" + t.isAlive());
		
		//设置线程为后台线程（守护线程）：系统默认是false，也就是前台线程
		//后台线程（守护线程）：专门给前台线程做服务的，如果前台线程都执行完销毁了，那么后台线程也会销毁
		t.setDaemon(true);
		t.start();
	}

}

class MyRunable2 implements Runnable{

	@Override
	public void run() {
		System.out.println("执行线程。。。");
		
		try {
			Thread.sleep(5000);  //线程休眠，时间到了之后继续执行下面的代码
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("当前线程名称为：" + Thread.currentThread().getName());
	}
	
}
