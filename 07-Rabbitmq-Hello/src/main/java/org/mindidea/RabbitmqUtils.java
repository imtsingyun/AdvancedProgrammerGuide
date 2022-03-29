package org.mindidea;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqUtils {
	public static Channel getChannel() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.1.231.103");
		factory.setUsername("admin");
		factory.setPassword("123");
		Connection connection = factory.newConnection();
		return connection.createChannel();
	}
}
