package com.bwf.thread;

public class ThreadDemo02 {

	public static int count = 1000; //1000张票
	
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("窗口1");
		MyThread2 t2 = new MyThread2("窗口2");
		MyThread2 t3 = new MyThread2("窗口3");
		
		t1.start();
		t2.start();
		t3.start();
		
		//匿名内部类写法
		new Thread("匿名线程"){
			public void run() {
				System.out.println("执行一个线程...");
			};
		}.start();
		
	}
	
}


class MyThread2 extends Thread{
	public  MyThread2(String name) {
		super(name);
	}
	
	@Override
	public void run() {
        //卖票
		for(int i = 0;i <1000;i++){
			System.out.println(getName()+"卖的票号为：" + (i+1));
		}
		super.run();
	}
	
}
