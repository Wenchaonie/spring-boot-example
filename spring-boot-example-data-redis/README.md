# SpringBoot-Redis

## SpringBoot集成Redis

#### *1. pom.xml添加依赖*

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

#### *2. application.properties配置*

```properties
spring.redis.host=localhost
spring.redis.port=6379
```

## 缓存穿透、缓存雪崩

#### *缓存穿透*

查询的某一个数据在缓存中一直不存在，造成每一次请求都查询DB的现象。

解决方案：

- 特殊Value

#### *缓存失效*

如果缓存在一段时间内失效，DB的压力凸显。

这个没有完美的解决办法，但可以分析用户行为，尽量让失效时间点均匀分布。

缓存失效的情况下，保证有且只有一个线程去更新缓存数据。

#### *缓存雪崩*

当缓存服务器重启或者大量缓存集中在某一个时间段失效，这样在失效的时候，也会给DB带来很大压力。

解决方案：

- 随机有效期5-10分钟
- 二级缓存。A1为原始缓存，A2为拷贝缓存，A1失效时，可以访问A2，A1缓存失效时间设置为短期，A2设置为长期
- 同步失败，记录操作日志

*PS：本文使用的是spring-boot-1.4.4.RELEASE、redis-3.2.100*