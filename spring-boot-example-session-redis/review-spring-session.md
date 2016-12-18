# SpringBoot-SpringSession源码阅后感

> spring-session是用于分布式系统共享HttpSession的，可以与spring-boot结合使用，默认使用Redis作为介质。

## 1. EnableRedisHttpSession启用SpringSession
```java
@Import(RedisHttpSessionConfiguration.class)
public @interface EnableRedisHttpSession {}
```

## 2. RedisHttpSessionConfiguration创建Filter
```java
@Bean
public ... springSessionRepositoryFilter(SessionRepository<S> sessionRepository, ...) {
	SessionRepositoryFilter<S> sessionRepositoryFilter = new SessionRepositoryFilter<S>(sessionRepository);
	sessionRepositoryFilter.setServletContext(servletContext);
	if(httpSessionStrategy != null) {
		sessionRepositoryFilter.setHttpSessionStrategy(httpSessionStrategy);
	}
	return sessionRepositoryFilter;
}
```
- `SessionRepository`接口，把`HttpSession`数据持久化。提供了两个实现类`MapSessionRepository`, `RedisOperationsSessionRepository`。默认使用后者，把数据保存到Redis
- `HttpSessionStrategy`接口，获取`sessionId`的策略。提供了两个实现类`HeaderHttpSessionStrategy`，`CookieHttpSessionStrategy`。默认使用后者，从Cookie中获取

## 3. SessionRepositoryFilter拦截所有请求
```java
@Order(SessionRepositoryFilter.DEFAULT_ORDER)
public class SessionRepositoryFilter<...> extends OncePerRequestFilter {
	public static final int DEFAULT_ORDER = Integer.MIN_VALUE + 50;
}
```
- 设定`SessionRepositoryFilter`的优先级，先运行

```java
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) ... {
	...

	SessionRepositoryRequestWrapper wrappedRequest = new SessionRepositoryRequestWrapper(request, response, servletContext);
	SessionRepositoryResponseWrapper wrappedResponse = new SessionRepositoryResponseWrapper(wrappedRequest,response);

	HttpServletRequest strategyRequest = httpSessionStrategy.wrapRequest(wrappedRequest, wrappedResponse);
	HttpServletResponse strategyResponse = httpSessionStrategy.wrapResponse(wrappedRequest, wrappedResponse);

	try {
		filterChain.doFilter(strategyRequest, strategyResponse);
	} finally {
		wrappedRequest.commitSession();
	}
}
```
- `SessionRepositoryRequestWrapper`，`HttpServletRequest`的子类，接管原来的request，重写了与session相关的方法
- `SessionRepositoryResponseWrapper`，`HttpServletResponse`的子类，接管原来的response