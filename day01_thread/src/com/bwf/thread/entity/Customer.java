package com.bwf.thread.entity;

/**
 * Ïû·ÑÕß
 */
public class Customer implements Runnable {

	private Product product;
	private int nums;

	public Customer(Product product, int nums) {
		super();
		this.product = product;
		this.nums = nums;
	}

	@Override
	public void run() {

		for (int i = 0; i < nums; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			product.xiaofeiProduct();
		}

	}

}
