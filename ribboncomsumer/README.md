##Ribbon
```text
    Ribbon是Netflix发布的负载均衡器，它可以帮我们控制HTTP和TCP客户端的行为。
只需为Ribbon配置服务提供者地址列表，Ribbon就可基于负载均衡算法计算出要请求的目标服务地址。
Ribbon默认为我们提供了很多的负载均衡算法，例如轮询、随机、响应时间加权等——当然，为Ribbon自定义负载均衡算法也非常容易，只需实现IRule 接口即可
```
+ 直接访问: localhost:7103/ribbon/test