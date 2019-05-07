package com.swust.fund.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author pang
 * @version V1.0
 * @ClassName: RedisConfig
 * @Package com.swust.question.config
 * @description: Redis配置
 * @date 2019/4/6 17:18
 */
@Configuration
@EnableCaching
public class RedisConfig {
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
    // @Value("${spring.Testaaa.host}")
    // private String host;
    //
    // @Value("${spring.Testaaa.port}")
    // private int port;
    //
    // @Value("${spring.Testaaa.timeout}")
    // private int timeout;
    //
    // @Value("${spring.Testaaa.pool.max-idle}")
    // private int maxIdle;
    //
    // @Value("${spring.Testaaa.pool.max-wait}")
    // private long maxWaitMillis;
    //
    // @Bean
    // public RedisProperties.Jedis redisPoolFactory() {
    //     Logger.getLogger(getClass()).info("JedisPool注入成功！！");
    //     Logger.getLogger(getClass()).info("redis地址：" + host + ":" + port);
    //     JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    //     jedisPoolConfig.setMaxIdle(maxIdle);
    //     jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
    //
    //     JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPool = new JedisPoolingClientConfigurationBuilder(jedisPoolConfig, host, port, timeout);
    //
    //     return jedisPool;
    // }
    // /**
    //  * 注入 RedisConnectionFactory
    //  */
    // @Autowired
    // private RedisConnectionFactory redisConnectionFactory;
    //
    // /**
    //  * 实例化 RedisTemplate 对象
    //  *
    //  * @return
    //  */
    // @Bean
    // public RedisTemplate<String, Object> functionDomainRedisTemplate() {
    //     RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    //     initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
    //     return redisTemplate;
    // }
    //
    // /**
    //  * 设置数据存入 Testaaa 的序列化方式
    //  *
    //  * @param redisTemplate
    //  * @param factory
    //  */
    // private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
    //     redisTemplate.setKeySerializer(new StringRedisSerializer());
    //     redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    //     redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
    //     redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    //     redisTemplate.setConnectionFactory(factory);
    // }
    //
    // /**
    //  * 实例化 HashOperations 对象,可以使用 Hash 类型操作
    //  *
    //  * @param redisTemplate
    //  * @return
    //  */
    // @Bean
    // public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
    //     return redisTemplate.opsForHash();
    // }
    //
    // /**
    //  * 实例化 ValueOperations 对象,可以使用 String 操作
    //  *
    //  * @param redisTemplate
    //  * @return
    //  */
    // @Bean
    // public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
    //     return redisTemplate.opsForValue();
    // }
    //
    // /**
    //  * 实例化 ListOperations 对象,可以使用 List 操作
    //  *
    //  * @param redisTemplate
    //  * @return
    //  */
    // @Bean
    // public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
    //     return redisTemplate.opsForList();
    // }
    //
    // /**
    //  * 实例化 SetOperations 对象,可以使用 Set 操作
    //  *
    //  * @param redisTemplate
    //  * @return
    //  */
    // @Bean
    // public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
    //     return redisTemplate.opsForSet();
    // }
    //
    // /**
    //  * 实例化 ZSetOperations 对象,可以使用 ZSet 操作
    //  *
    //  * @param redisTemplate
    //  * @return
    //  */
    // @Bean
    // public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
    //     return redisTemplate.opsForZSet();
    // }

}