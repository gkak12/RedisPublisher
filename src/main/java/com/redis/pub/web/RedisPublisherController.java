package com.redis.pub.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.pub.Domain.RedisDomain;
import com.redis.pub.service.RedisPublisherService;

@RestController
public class RedisPublisherController {

	@Resource(name = "RedisPublisherService")
	private RedisPublisherService redisPublisherService;
	
	@PostMapping(value = "/publish")
	public Map<String, String> publish(@RequestBody RedisDomain redisDomain){
		Map<String, String> res = new HashMap<String, String>();
		
		try {
			redisPublisherService.publishMessage(redisDomain);
			res.put("RESULT", "SUCCESS");
		} catch (Exception e) {
			res.put("RESULT", "FAIL");
		}
		
		return res;
	}
}
