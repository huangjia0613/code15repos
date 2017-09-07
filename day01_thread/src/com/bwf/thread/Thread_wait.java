package com.bwf.thread;

import com.bwf.thread.entity.Customer;
import com.bwf.thread.entity.Product;
import com.bwf.thread.entity.Productor;

/**
 * wait的使用
 * @author Administrator
 *
 */
public class Thread_wait {

	public static void main(String[] args) {
		Product p = new Product("产品",1);
		int nums = 100;
		//生产者、消费者模型
		new Thread(new Productor(p, nums)).start();
		new Thread(new Customer(p, nums)).start();
		
		
		new Thread(){
			public void run() {
				for(int i = 0;i<100;i++){
					//通知生产产品
					p.createProduct();
				}
			};
		}.start();
		
		
		new Thread(){
			public void run() {
				for(int i =0;i<100;i++) {
					try {
						//睡眠1秒之后再执行
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();

	}

}
