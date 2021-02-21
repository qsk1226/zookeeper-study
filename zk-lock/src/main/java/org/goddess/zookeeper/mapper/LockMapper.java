package org.goddess.zookeeper.mapper;

public interface LockMapper {

	//删除数据解锁
	int deleteByPrimaryKey(int id);

	//新增数据加锁，id为同一个值
	int insert(int id);

}