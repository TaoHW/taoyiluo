package com.taoyiluo.springbootquickstarterapi.utils.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Taohw
 * @Classname RabbitMqUtils
 * @Description TODO
 * @Date 2024/3/14 16:50
 * @Version V1.0
 */
public class RabbitMqUtils {
	//得到一个连接的channel
	public static Channel getChannel() throws Exception{
		//创建一个连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("120.79.89.43");
		factory.setUsername("admin");
		factory.setPassword("123");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		return channel;
	}
}
