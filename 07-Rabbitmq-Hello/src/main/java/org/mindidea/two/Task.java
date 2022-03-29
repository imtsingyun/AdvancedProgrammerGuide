package org.mindidea.two;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.mindidea.RabbitmqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Task {
	public static final String TASK_QUEUE_NAME = "ack_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		Channel channel = RabbitmqUtils.getChannel();
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String msg = scanner.next();
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
					msg.getBytes(StandardCharsets.UTF_8));
			System.out.println(msg);
		}
	}
}
