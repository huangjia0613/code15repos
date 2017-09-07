package com.bwf.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * �з���ֵ���̣߳��˽⣩
 * @author Administrator
 *
 */
public class ThreadDemo04 implements Callable<Integer>{
 
		
		public static void main(String[] args) {
			
			Callable<Integer> cellable = new ThreadDemo04();
			FutureTask<Integer> ft = new FutureTask<>(cellable);
			new Thread(ft).start();
			
			try {
				System.out.println("��ȡ����ֵ��"+ft.get());
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}
			
		}


		@Override
		
		public Integer call() throws Exception {
			System.out.println("cell...");
			return 1;
		}
}
