package com.bwf.thread;

public class ThreadDemo01 {

	public static void main(String[] args) {
		System.out.println("��ʼִ���̣߳�");
		MyThread myThread = new MyThread();
		myThread.setName("�߳�1");
		myThread.start();
		System.out.println("����ִ���̣߳�");
		
		//���û��thread.setName���߹��췽�������߳�����Ĭ����Thread-xxx
		System.out.println("�߳�����" + myThread.getName());
		
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
			System.out.println(getName()+"_������" + (i+1));
		}
	}
}
