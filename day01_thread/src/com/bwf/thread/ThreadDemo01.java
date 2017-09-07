package com.bwf.thread;

public class ThreadDemo01 {

	public static void main(String[] args) {
		System.out.println("开始执行线程！");
		MyThread myThread = new MyThread();
		myThread.setName("线程1");
		myThread.start();
		System.out.println("结束执行线程！");
		
		//如果没有thread.setName或者构造方法设置线程名，默认是Thread-xxx
		System.out.println("线程名：" + myThread.getName());
		
	}
}


class MyThread extends Thread{
	public MyThread(){
		super();
	}
	public MyThread(String name){
		super(name);
	}
	@Override
	public  void run() {
		for(int i = 0 ;i <100;i++){
			System.out.println(getName()+"_计数器" + (i+1));
		}
	}
}
