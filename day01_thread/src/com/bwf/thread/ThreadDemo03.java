package com.bwf.thread;
/**
 * ʵ��Runable�ӿ�
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
		 * һ��Runable������Ա����Thread������ʹ��;���Թ������
		 */
	}
	
}

/**1��дһ����ʵ��Runable�ӿ�
 * 2����дrun����
 * 3��ͨ��new Thread(runable)����һ���̣߳�����ͨ��start()�������� 
 * @author Administrator
 *
 */
class MyRunable implements Runnable{

	private int count = 100;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"ʣ�µ�Ʊ����"+count);
		count--;
	}
	
}
