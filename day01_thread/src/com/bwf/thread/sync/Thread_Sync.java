package com.bwf.thread.sync;

import org.apache.tomcat.jni.Thread;

/**
 * �̵߳�ͬ��
 * ͬ���ģ�StringBuffer��Vector��hashtable��Enumration��Collections��synchronizedXX
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
 * �߳�ͬ�������ַ�ʽ����1��ͬ�������  ��2��ͬ������  synchronized ����������ͬ����
 * @author Administrator
 *
 */
class MyTRunable implements Runnable{
	
	private int count = 100;

	@Override
	public void run() {
		//ͬ�������
//		synchronized (this) {
//			count--;
//			System.out.println("ʣ��Ʊ����" + count);
//		}
		sellTickets();
		
	}
	
	/**
	 * ��Ʊ������ֻ����˲������⣬�����ܽ������һ��Ʊ�������һ��������
	 */
	public synchronized void sellTickets() {
		for(int i = 0;i<count;i++){
			System.out.println(Thread.current()+ "����Ʊ��Ϊ��" +(i+1));
		}
	}
	
}
