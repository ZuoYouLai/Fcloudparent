## 08 hystrix + dashboard进行监控hystrix日志
+ controller将根目录直接转发到: "forward:/hystrix"
+ 使用
   ```text
    访问:
      localhost:8001
    启动带有hystrix监控的项目,例如:
        先访问：localhost:7105/feign/test
        然后这里才有相应的日志内容：localhost:7105/actuator/hystrix.stream
        
    在8001首页面进行输入:  localhost:7105/actuator/hystrix.stream
   ```

