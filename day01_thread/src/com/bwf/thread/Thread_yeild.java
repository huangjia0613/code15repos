package com.bwf.thread;

public class Thread_yeild {

	public static void main(String[] args) {
		MyThread7 t = new MyThread7();
		t.setName("线程1");
		/**
		 * 设置优先级：从1开始依次增大
		 * Thread.NORM_PRIORITY MIN_PRIORITY MAX_PRIORITY
		 */
		t.setPriority(Thread.NORM_PRIORITY);
        t.setPriority(10);
        
        for(int i=0;i<100;i++){
        	System.out.println("主线程：" + (i+1));
        	if (i== 20) {
				t.start();
				//不是礼让所有，是先礼让一些然后再抢回来，最后还是礼让给主线程
				//CPU从就绪状态线程队列中，只会选取与该线程优先级相同或者优先级更高的线程去执行
				t.yield();
			}
        }
	}

}

class MyThread7 extends Thread{
	@Override
	public void run() {
		for(int i = 0;i <100;i++){
			System.out.println(getName()+"序号："+(i+1));
			if (i== 10) {
				//中断，让其它线程先执行，还可以抢回来
				interrupt();
			}
		}
		super.run();
	}
}
