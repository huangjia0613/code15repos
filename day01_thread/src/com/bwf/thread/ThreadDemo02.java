package com.bwf.thread;

public class ThreadDemo02 {

	public static int count = 1000; //1000��Ʊ
	
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("����1");
		MyThread2 t2 = new MyThread2("����2");
		MyThread2 t3 = new MyThread2("����3");
		
		t1.start();
		t2.start();
		t3.start();
		
		//�����ڲ���д��
		new Thread("�����߳�"){
			public void run() {
				System.out.println("ִ��һ���߳�...");
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
        //��Ʊ
		for(int i = 0;i <1000;i++){
			System.out.println(getName()+"����Ʊ��Ϊ��" + (i+1));
		}
		super.run();
	}
	
}
