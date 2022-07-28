package org.mindidea._01_creation._00_singleton.enumdemo;

import lombok.Data;

/**
 * 模拟数据库连接池，连接池只有一个，所以需要使用单例模式
 *
 * @author Wang
 * @version V1.0
 * Created on 2022-7-28 15:30
 */
@Data
public class DBConnectionPool {

	private DBConnectionPool() {
	}

	public static DBConnectionPool getInstance() {
		return InstanceEnum.INSTANCE.instance;
	}

	/**
	 * 枚举类
	 *
	 * @author Wang
	 * @version V1.0
	 * Created on 2022-7-28 15:53
	 */
	private enum InstanceEnum {
		INSTANCE;

		private final DBConnectionPool instance;

		InstanceEnum() {
			instance = new DBConnectionPool();
		}
	}

	private String host = "127.0.0.1";
	private Integer port = 3307;
	private String database = "temp";
	private String user = "root";
	private String password = "123";

	@Override
	public String toString() {
		return "DBConnectionPool{" +
				"host='" + host + '\'' +
				", port=" + port +
				", database='" + database + '\'' +
				", user='" + user + '\'' +
				", password='" + password + '\'' +
				'}' + hashCode();
	}
}
