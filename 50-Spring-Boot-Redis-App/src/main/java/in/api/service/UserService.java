package in.api.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import in.api.model.User;

@Service
public class UserService {
	
	HashOperations<String,String,User> opsForHash = null; 
	/*
	 * HashOperations<String,String,User> 
	 *                HashName,Key,Value 
	 */
	
	public UserService(RedisTemplate<String,User> redisTemplate) {
		this.opsForHash = redisTemplate.opsForHash();
	}
	
	public String addUser(User user) {
		opsForHash.put("USERS",user.getId(),user);
		return "User Added";
	}
	
	public User getUser(String userId) {
		System.out.println(opsForHash.get("USERS",userId));
		return opsForHash.get("USERS",userId);
	}
	
	public Collection<User> getAllUsers(){
		Map<String, User> entries = opsForHash.entries("USERS");
		return entries.values();
	}

}
