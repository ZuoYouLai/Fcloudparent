##Ribbon
```text
    Ribbon是Netflix发布的负载均衡器，它可以帮我们控制HTTP和TCP客户端的行为。
只需为Ribbon配置服务提供者地址列表，Ribbon就可基于负载均衡算法计算出要请求的目标服务地址。
Ribbon默认为我们提供了很多的负载均衡算法，例如轮询、随机、响应时间加权等——当然，为Ribbon自定义负载均衡算法也非常容易，只需实现IRule 接口即可
```
+ 负载规则:
  ```text
    AvailabilityFilteringRule：过滤掉一直连接失败的被标记为circuit tripped的后端Server，并过滤掉那些高并发的后端Server或者使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个Server的运行状态；
    BestAvailableRule：选择一个最小的并发请求的Server，逐个考察Server，如果Server被tripped了，则跳过。
    RandomRule：随机选择一个Server；
    ResponseTimeWeightedRule：作用同WeightedResponseTimeRule，二者作用一样；
    RetryRule：对选定的负载均衡策略机上重试机制，在一个配置时间段内当选择Server不成功，则一直尝试使用subRule的方式选择一个可用的server；
    RoundRobinRule：轮询选择， 轮询index，选择index对应位置的Server；
    WeightedResponseTimeRule：根据响应时间加权，响应时间越长，权重越小，被选中的可能性越低；
    ZoneAvoidanceRule：复合判断Server所在区域的性能和Server的可用性选择Server；
  
    在配置文件的写法:
      provider:
        ribbon:
          NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RoundRobinRule 
  ```
+ 直接访问: localhost:7103/ribbon/test
  ```text
    RandomRule
    得出的结果：随机的访问
    RoundRobinRule : provider的机器可以进行随机访问
  ```
