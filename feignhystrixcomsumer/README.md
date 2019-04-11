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
    
    配置:
    feign:
      hystrix:
        enabled: true
    
    代码:  @HystrixCommand(fallbackMethod = "testFallback")
      @HystrixCommand(fallbackMethod = "testFallback")
      @GetMapping("/hystrix/test")
      public Map hystrixTest() {
          Map map = this.cFeignClient.hystrixtest();
          return map;
      }
  
  ```
+ hystrix怎么进行起熔断的作用
  ```text
    访问：
    localhost:7105/feign/hystrix/test
    localhost:7105/actuator/health  【既然访问不到】
    利用Auto Refresh来刷新页面内容: 发现有些请求可以正常请求 而线程睡眠长的则返回fallcallback
  ```    
+ feign + hystrix共同使用,开启hystrix的失败的回调的另外一种方式
   ```text
    配置:
    feign:
      hystrix:
        enabled: true
    代码在config中进行写fallcallback:
        @FeignClient(name = "provider", fallback = HystrixFeignClient.hyClient.class )
        public interface HystrixFeignClient {
        
            @GetMapping("/hystrix/test")
            Map hystrixtest();
        
        
            @Component
            public class hyClient implements HystrixFeignClient{
                @Override
                public Map hystrixtest() {
                    Map map = Maps.newHashMap();
                    map.put("value", "hystrix interface method");
                    return map;
                }
            }
        
        }
      
    访问:
      localhost:7105/hystrix/test  查看结果内容  【代码测试是生效的】
      
  ```  
  