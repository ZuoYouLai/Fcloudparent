## 11 微服务网关:zuul
####简介
Zuul是Netflix开源的微服务网关，它可以和Eureka、Ribbon、Hystrix等组件配合使用。Zuul的核心是一系列的过滤器，
这些过滤器帮助我们完成以下功能：
身份认证与安全：识别每个资源的验证要求，并拒绝那些与要求不符的请求；
审查与监控：在边缘位置追踪有意义的数据和统计结果，从而为我们带来精确的生产视图；
动态路由：动态地将请求路由到不同的后端集群；
压力测试：逐渐增加指向集群的流量，以了解性能；
负载分配：为每一种负载类型分配对应容量，并弃用超出限定值的请求；
静态响应处理：在边缘位置直接建立部分响应，从而避免其转发到内部集群；
多区域弹性：跨越AWS Region进行请求路由，旨在实现ELB（Elastic Load Balancing）使用的多样化；以及让系统的边缘更贴近系统的使用者
####使用
   ```text
    启动项目的服务地址:9001
    1.访问eureka服务是否存在zuul网关服务:
      http://localhost:7001/
    2.通过eureka服务查看服务列表内容:
      A.
      localhost:7101/test  对应的服务名称为:provider
      故访问:
      http://localhost:9001/provider/test  【正常可以访问】
      
      B.
      localhost:7102/cus/test  对应的服务名称为:eureka-consumer
      故访问:
      http://localhost:9001/eureka-consumer/cus/test  【正常可以访问】  

      C.
      localhost:7105/feign/test  对应的服务名称为:feign-hystrix-comsumer
      故访问:
      http://localhost:9001/feign-hystrix-comsumer/feign/test  【正常可以访问】        
      
      反向代理测试通过...
    
    3.断路器测试
      访问:
        http://localhost:9001/actuator/health    正常返回up日志信息
      访问:
        http://localhost:9001/actuator/hystrix.stream    正常返回hystrix日志内容
        说明zuul网关是集成hystrix熔断器的功能的  
   ```

