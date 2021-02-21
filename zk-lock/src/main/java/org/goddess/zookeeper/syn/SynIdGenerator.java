package org.goddess.zookeeper.syn;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SynIdGenerator {
	//全局订单id
	public static int count = 0;
	public static Object lock = new Object();

	public String getNumber() {
		synchronized (lock) {
			SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			return simpt.format(new Date()) + "-" + ++count/*+"_"+Thread.currentThread().getId()*/;
		}
	}

}
