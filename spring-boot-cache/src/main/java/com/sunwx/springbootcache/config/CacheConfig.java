package com.sunwx.springbootcache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import java.lang.reflect.Method;
import java.time.Duration;

@Configuration
@Component
@EnableCaching
//@PropertySource({"classpath:application.properties"})
public class CacheConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    private Duration timeout = Duration.ofDays(1);

    @Value("${spring.redis.database}")
    private int database;
    //@Value("${spring.redis.password}")
    //private String password;
    /**
     * springboot 2.0
     * 配置CacheManager 管理cache
     *
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration= RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(timeout)//设置失效时间
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))//设置默认key生成规则
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))//设置默认value生成规则
                .disableCachingNullValues();//不将null写入缓存
        RedisCacheManager redisCacheManager =RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration).transactionAware().build();
        return redisCacheManager;
    }
    //springboot 2.0之后转换键值对
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //序列化键
        template.setKeySerializer(keySerializer());
        template.setHashKeySerializer(keySerializer());
        //值序列化
        template.setValueSerializer(valueSerializer());
        template.setHashValueSerializer(valueSerializer());
        /*//使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();*/
        return template;
    }
    private RedisSerializer<String> keySerializer(){
        return new StringRedisSerializer();
    }
    private RedisSerializer<Object> valueSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }

}

