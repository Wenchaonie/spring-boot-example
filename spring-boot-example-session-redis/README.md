# SpringBoot-Redis共享HttpSession

## Redis简介

## 安装Redis

此处不进行详细说明。

## SpringBoot集成Redis、SpringSession

#### *1. pom.xml添加依赖*

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session</artifactId>
</dependency>
```

#### *2. application.properties配置*

```properties
spring.redis.host=localhost
spring.redis.port=6379
```

#### *3. HelloRestController添加/uuid接口，返回UUID*

```java
@RequestMapping("/uuid")
public String uuid(HttpSession session) {
    UUID uuid = (UUID) session.getAttribute("uuid");
    if (uuid == null) {
        uuid = UUID.randomUUID();
        session.setAttribute("uuid", uuid);
    }
    return uuid.toString();
}
```

#### *4. 进入项目打包，并以7070，7071端口启动*

```bash
mvn clean install -Dmaven.test.skip=true
java -jar target/spring-boot-example-session-redis-0.0.1.jar --server.port=7070
java -jar target/spring-boot-example-session-redis-0.0.1.jar --server.port=7071
```

#### *5. 在浏览器中分别访问/uuid接口，比较UUID的异同*

`http://localhost:7070/uuid` 返回 `a1f17b46-fb10-4e5c-94ab-709511304e36`  
`http://localhost:7071/uuid` 返回 `a1f17b46-fb10-4e5c-94ab-709511304e36`

*PS：本文使用的是spring-boot-1.4.4.RELEASE、redis-3.2.100*