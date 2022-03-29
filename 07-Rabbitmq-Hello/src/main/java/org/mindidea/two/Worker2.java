package org.mindidea.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.mindidea.RabbitmqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker2 {
	public static final String TASK_QUEUE_NAME = "ack_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		Channel channel = RabbitmqUtils.getChannel();
		channel.basicQos(1);
		System.out.println("c2 is waiting");
		DeliverCallback callback = (consumerTag, message) -> {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new String(message.getBody()));
			channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
		};
		CancelCallback cancelCallback = consumerTag -> {
			System.out.println("abort");
		};
		channel.basicConsume(TASK_QUEUE_NAME, false, callback, cancelCallback);
	}
}
