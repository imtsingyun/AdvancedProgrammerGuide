package org.mindidea.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

	public static final String QUEUE_NAME = "hello";

	public static void main(String[] args) throws IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("10.1.231.103");
		factory.setUsername("admin");
		factory.setPassword("123");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		DeliverCallback callback = (consumerTag, message) -> {
			System.out.println(new String(message.getBody()));
		};
		CancelCallback cancelCallback = consumerTag -> {
			System.out.println("abort");
		};
		channel.basicConsume(QUEUE_NAME, false, callback, cancelCallback);
	}
}
