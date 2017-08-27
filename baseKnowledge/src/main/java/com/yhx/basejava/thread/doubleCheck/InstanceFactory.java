package com.yhx.basejava.thread.doubleCheck;

public class InstanceFactory {

	private static class InstaceHolder{
		public static Instance instance=new Instance();
	}
	
	public  Instance getInstance(){		
		return InstaceHolder.instance;		
	}
	
	public static void main(String[] args){
		
		Thread t1=new Thread(new Runnable(){

			public void run() {
				InstanceFactory factory=new InstanceFactory();
				factory.getInstance();
				System.out.println("t1 has done");
			}
		});
		t1.setName("t1");
		
		Thread t2=new Thread(new Runnable(){

			public void run() {
				InstanceFactory factory=new InstanceFactory();
				factory.getInstance();
				System.out.println("t2 has done");				
			}
		});
		t2.setName("t2");
		
		Thread t3=new Thread(new Runnable(){

			public void run() {
				InstanceFactory factory=new InstanceFactory();
				factory.getInstance();
				System.out.println("t3 has done");				
			}
		});
		t3.setName("t2");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
