package com.bwf.thread;

public class Thread_join {

	/**
	 * join的使用
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread6 t = new MyThread6();
		t.setName("测试线程");

		for(int i = 0;i <100;i++){
			System.out.println("main"+(i+1));
			//默认子线程在main线程20以后打印，并且之后的打印是和main线程穿插进行（因为要抢占CPU资源）
			if (i == 20) {
				t.start();
				try {
					//main先暂停，让t先执行，然后main线程再继续执行
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
			System.out.println(getName()+"当前序号为："+(i+1));
		}
		super.run();
	}
}
