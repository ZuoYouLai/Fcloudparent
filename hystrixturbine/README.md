## 09 监控数据聚合-Turbine [监控多个hystrix服务的日志内容]
####简介
Turbine是一个聚合Hystrix监控数据的工具，它可将所有相关/hystrix.stream端点的数据聚合到一个组合的/turbine.stream中，从而让集群的监控更加方便。
####使用
   ```text
    访问:
      http://localhost:8002/turbine.stream  可以监控到日志内容
    启动2个带有hystrix监控的项目,例如:
        localhost:7105/feign/test
        localhost:7106/feign/test
        然后这里才有相应的日志内容：localhost:7105/actuator/hystrix.stream
        然后这里才有相应的日志内容：localhost:7106/actuator/hystrix.stream
   ```

