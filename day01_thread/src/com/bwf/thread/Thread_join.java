package com.bwf.thread;

public class Thread_join {

	/**
	 * join��ʹ��
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread6 t = new MyThread6();
		t.setName("�����߳�");

		for(int i = 0;i <100;i++){
			System.out.println("main"+(i+1));
			//Ĭ�����߳���main�߳�20�Ժ��ӡ������֮��Ĵ�ӡ�Ǻ�main�̴߳�����У���ΪҪ��ռCPU��Դ��
			if (i == 20) {
				t.start();
				try {
					//main����ͣ����t��ִ�У�Ȼ��main�߳��ټ���ִ��
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

class MyThread6 extends Thread{
	@Override
	public void run() {
		for(int i = 0;i <100;i++){
			System.out.println(getName()+"��ǰ���Ϊ��"+(i+1));
		}
		super.run();
	}
}
