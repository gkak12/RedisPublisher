package com.redis.pub.Domain;

import lombok.Data;

@Data
public class RedisDomain {

	private String channel;
	
	private String message;
}
