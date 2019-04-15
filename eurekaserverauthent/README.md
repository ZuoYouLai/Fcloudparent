## 服务发现 eureka-server + 安全校验
+ 直接访问: localhost:7011  需要进行登录操作： samlai:samlai123
+ 作为eureka的client端需要这样设计url: http://samlai:samlai123@localhost:7011/eureka/

+ [eureka其他问题](http://www.itmuch.com/spring-cloud-sum-eureka/)
+ [eureka的最佳实践](https://github.com/spring-cloud/spring-cloud-netflix/issues/203)