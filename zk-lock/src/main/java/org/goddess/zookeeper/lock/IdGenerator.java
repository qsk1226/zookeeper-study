package org.goddess.zookeeper.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 ReentrantLock 实现的需要生成器
 */
public class IdGenerator {
	//全局订单id
	public static int count = 0;
	private Lock lock = new ReentrantLock();

	//以lock的方式解决
	public String getNumber() {
		try {
			lock.lock();
			SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			return simpt.format(new Date()) + "-" + ++count;
		} finally {
			lock.unlock();
		}
	}

}


