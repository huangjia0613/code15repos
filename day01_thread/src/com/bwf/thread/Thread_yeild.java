package com.bwf.thread;

public class Thread_yeild {

	public static void main(String[] args) {
		MyThread7 t = new MyThread7();
		t.setName("�߳�1");
		/**
		 * �������ȼ�����1��ʼ��������
		 * Thread.NORM_PRIORITY MIN_PRIORITY MAX_PRIORITY
		 */
		t.setPriority(Thread.NORM_PRIORITY);
        t.setPriority(10);
        
        for(int i=0;i<100;i++){
        	System.out.println("���̣߳�" + (i+1));
        	if (i== 20) {
				t.start();
				//�����������У���������һЩȻ��������������������ø����߳�
				//CPU�Ӿ���״̬�̶߳����У�ֻ��ѡȡ����߳����ȼ���ͬ�������ȼ����ߵ��߳�ȥִ��
				t.yield();
			}
        }
	}

}

class MyThread7 extends Thread{
	@Override
	public void run() {
		for(int i = 0;i <100;i++){
			System.out.println(getName()+"��ţ�"+(i+1));
			if (i== 10) {
				//�жϣ��������߳���ִ�У�������������
				interrupt();
			}
		}
		super.run();
	}
}
