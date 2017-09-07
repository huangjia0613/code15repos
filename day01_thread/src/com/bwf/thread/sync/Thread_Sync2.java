package com.bwf.thread.sync;

/**
 * ����
 * @author Administrator
 *
 */
public class Thread_Sync2 {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		new Thread(){
			public void run() {
				//a��b��������
				a.say(b);
			};
		}.start();
		//b��a��������
		b.say(a);

	}

}

/**
 * synchronize�Ѷ�����������
 * @author Administrator
 *
 */
class A{
	public void say(B b) {
		System.out.println("B ����ҿ��ţ�");
		b.operDoor();
	}
	
	public synchronized void operDoor() {
		System.out.println("��B����");

	}
}


class B{

	public void say(A a) {
		System.out.println("A  ����ҿ���");
		a.operDoor();
	}
	
	
	public synchronized void operDoor() {
		System.out.println("��A���ţ�");
		
	}
	
}
