package org.goddess.zookeeper.zk;


import org.goddess.zookeeper.simple.SimpleIdGenerator;

public class ZkIdGeneratorDemo implements Runnable {
	private SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator();

	private ZkLock lock = new DistrbuteZkLock2();

	public void run() {
		getNumber();
	}

	public void getNumber() {
		try {
			lock.lock();
			String number = simpleIdGenerator.getNumber();
			System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
		}
	}

	public static void main(String[] args) {
		System.out.println("####生成唯一订单号###");
		for (int i = 0; i < 50; i++) {
			new Thread(new ZkIdGeneratorDemo()).start();
		}
	}
}