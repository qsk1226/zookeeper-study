package org.goddess.zookeeper.syn;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;


//使用多线程模拟生成订单号
public class SynIdGeneratorDemo implements Runnable {
	private SynIdGenerator synIdGenerator = new SynIdGenerator();

	private static CountDownLatch countDownLatch = new CountDownLatch(50);

	private static List<String> result = new Vector<String>();


	public void run() {
		try {
			countDownLatch.await();
			result.add(synIdGenerator.getNumber());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws InterruptedException {

		System.out.println("####生成唯一订单号###");

		for (int i = 0; i < 50; i++) {
			new Thread(new SynIdGeneratorDemo()).start();
			countDownLatch.countDown();
		}


		Thread.sleep(1000);

		Collections.sort(result);
		for (String str : result) {
			System.out.println(str);
		}

	}
}