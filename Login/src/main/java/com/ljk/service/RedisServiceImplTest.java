package com.ljk.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service("redisServiceTest")
public class RedisServiceImplTest implements RedisServiceTest {
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    public void set( String username,  String passwordMD5) {
        this.stringRedisTemplate.opsForValue().set(username, passwordMD5);
    }
    public String get( String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }
    
    public Long increment( String key,  Long l) {
        return this.stringRedisTemplate.opsForValue().increment(key, l);
    }
	public String getUser(String username) {
		return this.stringRedisTemplate.opsForValue().get(username);
	}
	public void setMap(String key, Map values) {
		 try{
			 this.stringRedisTemplate.opsForHash().putAll(key, values);
		 }catch(Exception e){
			 System.out.print(e);
		 }
		
	}
	public Map<Object, Object> getMap(String key) {
		Map<Object, Object> resultMap =null;
		  resultMap= this.stringRedisTemplate.opsForHash().entries(key);
		  return resultMap;
		
	}

}
