/*
 * Copyright (C), 2002-2017, bigmoon,All Rights Reserved.
 * FileName: ConnectionPool.java
 * Author:   bigmoon
 * Date:     19-6-13 上午11:18
 * Description: baseKnowledge
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * bigmoon     19-5-23 下午6:17      版本号        描述
 */

package bigmoon.learning.basejava.thread.waitTimeOut;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {

	private LinkedList<Connection> pool = new LinkedList<Connection>();

	public ConnectionPool(int initCount) {

		if (initCount > 0) {

			for (int i = 0; i < initCount; i++) {
				pool.addLast(ConnectionDriver.createConncetion());
			}
		}
	}

	public void releaseConnection(Connection con) {

		if (null != con) {

			synchronized (pool) {
				// 释放链接，发送通知
				pool.addLast(con);
				pool.notifyAll();
			}
		}
	}

	public Connection fetchConnection(long millis) throws InterruptedException {
		Connection result = null;
		
		synchronized (pool) {
			
			if (millis > 0) {

				long future = System.currentTimeMillis() + millis;
				long waitTime = millis;
				
				while (pool.isEmpty() && waitTime > 0) {
					// 等待超时模式					
					pool.wait(waitTime);
					waitTime = future - System.currentTimeMillis();
				}
			} else {

				while (pool.isEmpty()) {
					System.out.println(Thread.currentThread().getName() + " pool is empty");
					pool.wait();
				}
			}

			if (!pool.isEmpty()) {
				result = pool.removeFirst();
			}
		}
		return result;
	}
}
