### Sleuth来实现调用链监控
+ 配置文件详情
+ 访问: localhost:9099/test

#### sleuth 与 zipkin 集成  [资料](http://www.itmuch.com/spring-cloud/finchley-25/)
+ docker运行 : docker run -d -p 9411:9411 openzipkin/zipkin
+ 本地运行 : [官网](https://zipkin.io/pages/quickstart.html)
```text
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
    java -jar zipkin.jar
    
    直接运行： http://localhost:9411/zipkin/
    可以查看可视化的界面内容
    
    测试访问: localhost:9099/test   再进行查看zipkin界面的服务内容
```
