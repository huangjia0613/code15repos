package com.bwf.thread.entity;

import java.io.Serializable;

/**
 * 产品类
 */
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1274634673467673L;
	
	private String pName;
	private int pID;
	
	
	public Product(String pName, int pID) {
		super();
		this.pName = pName;
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	@Override
	public String toString() {
		return "Product [pName=" + pName + ", pID=" + pID + "]";
	}
	
	/**
	 * 生成产品的
	 */
	public synchronized void createProduct(){
		System.out.println("生成产品...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 消费产品
	 */
	public synchronized void xiaofeiProduct(){
		System.out.println("消费产品...");
		notify();
//		notifyAll();
	}
	
	
}
