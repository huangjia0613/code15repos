package com.bwf.thread;

import com.bwf.thread.entity.Customer;
import com.bwf.thread.entity.Product;
import com.bwf.thread.entity.Productor;

/**
 * wait��ʹ��
 * @author Administrator
 *
 */
public class Thread_wait {

	public static void main(String[] args) {
		Product p = new Product("��Ʒ",1);
		int nums = 100;
		//�����ߡ�������ģ��
		new Thread(new Productor(p, nums)).start();
		new Thread(new Customer(p, nums)).start();
		
		
		new Thread(){
			public void run() {
				for(int i = 0;i<100;i++){
					//֪ͨ������Ʒ
					p.createProduct();
				}
			};
		}.start();
		
		
		new Thread(){
			public void run() {
				for(int i =0;i<100;i++) {
					try {
						//˯��1��֮����ִ��
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();

	}

}
