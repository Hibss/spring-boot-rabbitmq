package com.jfz.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author steven.sheng
 */
@Component
public class JfzSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(int i) {
		String context = "spirng boot jfz queue"+" ****** "+i;
		System.out.println("Sender1 : " + context);
		this.rabbitTemplate.convertAndSend("jfz", context);
	}

}