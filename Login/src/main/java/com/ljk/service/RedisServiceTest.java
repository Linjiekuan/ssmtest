package com.ljk.service;

import java.util.Map;

public interface RedisServiceTest {
	String  getUser(String key);
	void set(String key, String values);
	String get( String key);
	Long increment( String key,  Long l);
	void setMap(String key, Map values);
	Map<Object, Object> getMap(String key);
	
}
