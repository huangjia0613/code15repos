package com.bwf.thread;



public class ThreadDemo05 extends Thread{

	public static void main(String[] args) {
		
		new ThreadDemo05().start();

	}
	
     public synchronized void start() {
		
		System.out.println("����״̬������");
		super.start();

	}
     
     @Override
    public void run() {
    	System.out.println("����״̬������");
    	super.run();
    }

}
