package com.redis.pub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.redis.pub.Domain.RedisDomain;

@Service(value = "RedisPublisherService")
public class RedisPublisherService {

	private final RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	public RedisPublisherService(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void publishMessage(RedisDomain redisDomain) throws Exception{
		String channel = redisDomain.getChannel();
		String message = redisDomain.getMessage();
		
		redisTemplate.convertAndSend(channel, message);
	}
}
