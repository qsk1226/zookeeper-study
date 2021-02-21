package org.goddess.zookeeper.simple;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;


//使用多线程模拟生成订单号
public class SimpleIdGeneratorDemo implements Runnable {
	private SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator();

	//发令枪，模拟50个并发
	private static CountDownLatch countDownLatch = new CountDownLatch(50);

	private static List<String> result = new Vector<String>();


	public void run() {
		try {
			countDownLatch.await();
			result.add(simpleIdGenerator.getNumber());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws InterruptedException {

		System.out.println("####生成唯一订单号###");

		for (int i = 0; i < 50; i++) {
			new Thread(new SimpleIdGeneratorDemo()).start();
			countDownLatch.countDown();
		}

		//countDownLatch.await();

		Thread.sleep(1000);

		Collections.sort(result);
		for (String str : result) {
			System.out.println(str);
		}

	}
}