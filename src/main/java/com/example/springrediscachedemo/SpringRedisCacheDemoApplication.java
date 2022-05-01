package com.example.springrediscachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@SpringBootApplication
@EnableCaching
public class SpringRedisCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCacheDemoApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        RedisSerializationContext.SerializationPair serializationPair
                = RedisSerializationContext.SerializationPair.fromSerializer(serializer);
        RedisCacheConfiguration redisCacheConfiguration
                = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(serializationPair);
        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);

    }

}
