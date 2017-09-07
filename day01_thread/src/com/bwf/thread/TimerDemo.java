package com.bwf.thread;



import java.util.Timer;
import java.util.TimerTask;

import com.bwf.thread.utils.DateUtils;


/**
 * 计时器：Timer(执行TimerTask)、TimerTask
 * 1、写一个类继承TimerTask类
 * 2、重写run方法，执行任务代码
 * 3、使用Timer把TimerTask加入到任务中
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
		System.out.println("当前时间为："+ DateUtils.getNowTime());
		
	}
	
}