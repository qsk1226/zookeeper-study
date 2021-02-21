package org.goddess.zookeeper.zk;


public interface ZkLock {
	//获取到锁的资源
	public void lock();

	// 释放锁
	public void unLock();
}
