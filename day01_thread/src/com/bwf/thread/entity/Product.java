package com.bwf.thread.entity;

import java.io.Serializable;

/**
 * ��Ʒ��
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
	 * ���ɲ�Ʒ��
	 */
	public synchronized void createProduct(){
		System.out.println("���ɲ�Ʒ...");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���Ѳ�Ʒ
	 */
	public synchronized void xiaofeiProduct(){
		System.out.println("���Ѳ�Ʒ...");
		notify();
//		notifyAll();
	}
	
	
}
