package com.bwf.thread;
/**
 * 同步的单例模式
 * @author Administrator
 *
 */
public class SignObject {

	private static SignObject signObject;
	private SignObject () {
		
	}
	
	/**
	 * 给getInstanse加上同步锁，这样就保证有一个SignObject对象，并且不会报错
	 * @return
	 */
	public synchronized static SignObject getInstanse(){
		if (signObject == null) {
			signObject = new SignObject();
		}
		return signObject;	
	}

	
}


