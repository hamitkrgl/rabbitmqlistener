package com.bilgeadam.rabbitmqListener.listener;

import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bilgeadam.rabbitmqListener.dto.Person;

@Component
public class RabbitComponent {

	@Bean
	public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@RabbitListener(queues = "rabbitDirectQueueDLX")
	public void sendReceiptEmail(@Payload Person person) throws Exception {
		System.err.println("Listener got the person -> " + person.toString());

		if (new Random().nextInt(5) == 3) {
			throw new Exception("Birşeyler birşeyler");
		}
		while (new Random().nextInt(99999999) != 55555555) {

		}
	}
}
