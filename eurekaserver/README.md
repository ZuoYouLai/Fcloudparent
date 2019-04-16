## 01服务发现 eureka-server
+ 直接访问: localhost:7001
+ [eureka其他问题](http://www.itmuch.com/spring-cloud-sum-eureka/)
+ [eureka的最佳实践](https://github.com/spring-cloud/spring-cloud-netflix/issues/203)
+ [Eureka的自我保护模式](http://www.itmuch.com/spring-cloud-sum/understanding-eureka-self-preservation/)
  ```text
    自我保护模式:
       一种应对网络异常的安全保护措施。它的架构哲学是宁可同时保留所有微服务（健康的微服务和不健康的微服务都会保留），也不盲目注销任何健康的微服务。
       使用自我保护模式，可以让Eureka集群更加的健壮、稳定
    设置:
      eureka.server.enable-self-preservation = false 
  ```
