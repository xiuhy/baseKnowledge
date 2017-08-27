package com.yhx.basejava.thread;

public class Interrupted {

	static class SleepRunner implements Runnable{

		public void run() {
			while(true){
				//SleepUtils.second(10);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}		
	}
	
	static class BusyRunner implements Runnable{

		public void run() {
			while(true){
				
			}
			
		}		
	}
	
	public static void main(String[] args){
		Thread sleepThread=new Thread(new SleepRunner(),"sleep");
		Thread busyThread=new Thread(new BusyRunner(),"BusyRunner");
		sleepThread.setDaemon(true);
		busyThread.setDaemon(true);
		sleepThread.start();
		busyThread.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sleepThread.interrupt();
		busyThread.interrupt();
		System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is "+busyThread.isInterrupted());
		busyThread.interrupt();
		System.out.println("busyThread interrupted again,interrupted="+busyThread.interrupted()+",isInterrupted="+busyThread.isInterrupted());
				
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
