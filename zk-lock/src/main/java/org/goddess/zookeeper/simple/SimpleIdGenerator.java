package org.goddess.zookeeper.simple;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleIdGenerator {
	//全局订单id
	public static int count = 0;

	//生成订单ID
	public String getNumber() {
		SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return simpt.format(new Date()) + "-" + ++count;
	}

}
