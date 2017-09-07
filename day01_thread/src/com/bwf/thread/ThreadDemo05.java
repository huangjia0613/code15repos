package com.bwf.thread;



public class ThreadDemo05 extends Thread{

	public static void main(String[] args) {
		
		new ThreadDemo05().start();

	}
	
     public synchronized void start() {
		
		System.out.println("¾ÍÐ÷×´Ì¬¡£¡£¡£");
		super.start();

	}
     
     @Override
    public void run() {
    	System.out.println("ÔËÐÐ×´Ì¬¡£¡£¡£");
    	super.run();
    }

}
