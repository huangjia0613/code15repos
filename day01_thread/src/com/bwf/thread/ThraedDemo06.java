package com.bwf.thread;

public class ThraedDemo06 {

	/**
	 * Ĭ�϶�����һ�����̣߳�GC�߳�
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunable2());
		t.setName("�߳�1");
//		t.start();
//		System.out.println("�߳�����Ϊ��" + t.getName());
		//Thread.currentThread()�ĸ��߳����ŵģ��������Ǹ��߳��У����õľ����Ǹ��߳�
		System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName());
		
		System.out.println("�߳��Ƿ������У�" + t.isAlive());
		
		//�����߳�Ϊ��̨�̣߳��ػ��̣߳���ϵͳĬ����false��Ҳ����ǰ̨�߳�
		//��̨�̣߳��ػ��̣߳���ר�Ÿ�ǰ̨�߳�������ģ����ǰ̨�̶߳�ִ���������ˣ���ô��̨�߳�Ҳ������
		t.setDaemon(true);
		t.start();
	}

}

class MyRunable2 implements Runnable{

	@Override
	public void run() {
		System.out.println("ִ���̡߳�����");
		
		try {
			Thread.sleep(5000);  //�߳����ߣ�ʱ�䵽��֮�����ִ������Ĵ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��ǰ�߳�����Ϊ��" + Thread.currentThread().getName());
	}
	
}
