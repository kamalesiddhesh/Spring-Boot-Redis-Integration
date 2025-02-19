package in.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.api.model.User;

@Configuration
public class RedisConfig {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory () {
		JedisConnectionFactory jcf = new JedisConnectionFactory();		
		return jcf;
	}
	
	@Bean
	RedisTemplate<String,User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;		
	}

}
