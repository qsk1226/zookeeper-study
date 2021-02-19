package org.goddess.zookeeper;

import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;

/**
 * digest 认证方式的密码密文获取
 *
 * @author qinshengke
 * @since 2021/2/20
 **/
public final class DigestGenerator {

	public static String generateDigest(String idPassword) {
		// zkServer.sh 脚本指定启动参数 -Dzookeeper.DigestAuthenticationProvider.superDigest=super:superPassword
		// String superPassword = DigestAuthenticationProvider.generateDigest("super:admin");

		String digestPassword = null;
		try {
			digestPassword = DigestAuthenticationProvider.generateDigest("user1:123456");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digestPassword;
	}
}
