package com.bwf.thread;



import java.util.Timer;
import java.util.TimerTask;

import com.bwf.thread.utils.DateUtils;


/**
 * ��ʱ����Timer(ִ��TimerTask)��TimerTask
 * 1��дһ����̳�TimerTask��
 * 2����дrun������ִ���������
 * 3��ʹ��Timer��TimerTask���뵽������
 * @author Administrator
 *
 */
public class TimerDemo {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1000,1000);
	}
}


class MyTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("��ǰʱ��Ϊ��"+ DateUtils.getNowTime());
		
	}
	
}