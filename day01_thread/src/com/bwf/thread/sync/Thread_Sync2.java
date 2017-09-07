package com.bwf.thread.sync;

/**
 * 死锁
 * @author Administrator
 *
 */
public class Thread_Sync2 {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		new Thread(){
			public void run() {
				//a叫b给他开门
				a.say(b);
			};
		}.start();
		//b叫a给他开门
		b.say(a);

	}

}

/**
 * synchronize把对象锁起来了
 * @author Administrator
 *
 */
class A{
	public void say(B b) {
		System.out.println("B 你给我开门！");
		b.operDoor();
	}
	
	public synchronized void operDoor() {
		System.out.println("给B开门");

	}
}


class B{

	public void say(A a) {
		System.out.println("A  你给我开门");
		a.operDoor();
	}
	
	
	public synchronized void operDoor() {
		System.out.println("给A开门！");
		
	}
	
}
