/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: MainClient.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.threadlocal;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainClient {

	private static ThreadLocal<Integer> values=new ThreadLocal<Integer>(){
		
		private Random  random=new Random(45);
		
		protected  Integer initialValue() {			 
			return random.nextInt();
		}
		
	};
	
	public static int get(){return values.get();}
	
	public static void increment(){values.set(values.get()+1);}
	
	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {		
		
//		ExecutorService exec=Executors.newCachedThreadPool();
//		
//		for(int i=0;i<5;i++){
//			exec.execute(new Accessor(i));			
//		}
//		
//		TimeUnit.SECONDS.sleep(3);
//		exec.shutdown();
		ThreadLocalRandom.current().nextDouble(200);
		char c='a';
		char b='在';
		String t=new String(new char[]{b});
		System.out.println("length chines="+t.getBytes("utf8").length);
	}

}
