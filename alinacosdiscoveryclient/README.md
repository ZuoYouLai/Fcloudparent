##Spring Cloud Alibaba : 服务发现nacos [服务消费者:comsumer]
+ 新建一个服务发现的生产者: ali-nacos-discovery-client  [这个是服务消费者]
+ 启动application的时候【日志虽然有报错,但不影响服务的注册到nacos上】，查看nacos中的 【服务列表】 有相应服务名称 【ali-nacos-discovery-client】 是处于正常的健康状态
+ 访问: localhost:7702/test?name=mr.samlaiyou
  ```text
    返回的结果为:
      Invoke : http://10.0.10.21:7701/hello?name=mr.samlaiyou , return : hello mr.samlaiyou
    正常的消费者调用服务提供者
  ```
+ 当添加多一个server调用的节点的时候,则达到负载均衡的调用  
 ```text
    返回的结果为:
        
  ```
+ [支持的几种服务消费方式（RestTemplate、WebClient、Feign)](http://blog.didispace.com/spring-cloud-alibaba-2/) 
  ```text
    feign方式注意点:
    需要注意点： 这里使用FeignClient 则需要在application上添加注解 @EnableFeignClients
  
    rest方式注意点:
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
       return new RestTemplate();
    }
  
  
    分别访问:
      localhost:7702/fei/test
      localhost:7702/rest/test
    
    测试正确
  ``` 