package com.bwf.thread;
/**
 * ͬ���ĵ���ģʽ
 * @author Administrator
 *
 */
public class SignObject {

	private static SignObject signObject;
	private SignObject () {
		
	}
	
	/**
	 * ��getInstanse����ͬ�����������ͱ�֤��һ��SignObject���󣬲��Ҳ��ᱨ��
	 * @return
	 */
	public synchronized static SignObject getInstanse(){
		if (signObject == null) {
			signObject = new SignObject();
		}
		return signObject;	
	}

	
}


