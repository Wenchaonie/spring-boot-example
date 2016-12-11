# SpringBoot-Redis共享HttpSession

## 1. 在pom中添加依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
</dependency>
```

## 2. 在controller添加接口，返回sessionId
```
@RequestMapping("/sid")
public String sid(HttpSession session) {
    return session.getId();
}
```

## 3. 进入项目打包，并以7070，7071端口启动
```
> mvn clean install -Dmaven.test.skip=true
> java -jar target/spring-boot-example-session-redis-0.0.1-SNAPSHOT.jar --server.port=7070
> java -jar target/spring-boot-example-session-redis-0.0.1-SNAPSHOT.jar --server.port=7071
```

## 4. 分别访问/sid接口，比较sessionId的异同
`http://localhost:7070/session/sid` 返回 `bb076b71-83a3-4c39-af7f-928f0e92e9e9`
`http://localhost:7071/session/sid` 返回 `bb076b71-83a3-4c39-af7f-928f0e92e9e9`

经实践得知，只有当`server.contextPath`相同时，`HttpSession`才能共享，具体原因还没深究

*PS：本文使用的是spring-boot-1.3.8.RELEASE*