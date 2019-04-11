## feign
+ [资料参考](http://www.itmuch.com/spring-cloud/finchley-9/)
+ 简介
  ```text
    Feign是Netflix开发的声明式、模板化的HTTP客户端，其灵感来自Retrofit、JAXRS-2.0以及WebSocket。Feign可帮助我们更加便捷、优雅地调用HTTP API。
    在Spring Cloud中，使用Feign非常简单——只需创建接口，并在接口上添加注解即可。
    Feign支持多种注解，例如Feign自带的注解或者JAX-RS注解等。Spring Cloud对Feign进行了增强，使其支持Spring MVC注解，另外还整合了Ribbon和Eureka，从而使得Feign的使用更加方便。
  ```
+ 访问: localhost:7105/feign/test  

+ 其他特性: [来自](http://www.itmuch.com/spring-cloud/finchley-10/)
  ```text
      生产技巧：Feign如何控制Hystrix的启停、超时、熔断？
      使用Feign实现Form表单提交
      如何使用Feign构造多参数的请求
      Spring Cloud中，Feign常见问题总结
      Spring Cloud中，如何解决Feign/Ribbon第一次请求失败的问题？
      使用Spring Cloud Feign上传文件
  ```
+ feign + hystrix 一起使用,开放hystrix的功能,
  ```text
    访问:访问任意Feign Client接口的API后，再访问http://IP:PORT/actuator/hystrix.stream   
    localhost:7105/feign/test
    localhost:7105/actuator/hystrix.stream
  ```
    
  