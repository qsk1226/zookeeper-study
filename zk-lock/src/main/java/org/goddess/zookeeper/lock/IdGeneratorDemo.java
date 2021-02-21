package org.goddess.zookeeper.lock;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;


/**
 * 使用多线程模拟生成订单号
 */
public class IdGeneratorDemo implements Runnable {
	private final IdGenerator idGenerator = new IdGenerator();
	private static final CountDownLatch countDownLatch = new CountDownLatch(50);
	private static final List<String> result = new Vector<String>();

	public void run() {
		try {
			countDownLatch.await();
			result.add(idGenerator.getNumber());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) throws InterruptedException {

		System.out.println("####生成唯一订单号###");

		IdGeneratorDemo idGeneratorDemo = new IdGeneratorDemo();
		for (int i = 0; i < 50; i++) {
			new Thread(idGeneratorDemo).start();
			countDownLatch.countDown();
		}


		Thread.sleep(1000);

		Collections.sort(result);
		for (String str : result) {
			System.out.println(str);
		}

	}
}