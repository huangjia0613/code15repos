package com.bwf.thread.entity;

/**
 * ЩњВњеп
 * 
 * @author Administrator
 *
 */
public class Productor implements Runnable {

	private Product product;
	private int nums;

	public Productor(Product product, int nums) {
		super();
		this.product = product;
		this.nums = nums;
	}

	@Override
	public void run() {
		for (int i = 0; i < nums; i++) {
			product.createProduct();
		}
	}

}
