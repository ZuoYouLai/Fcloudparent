##Spring Cloud Alibaba : 服务发现nacos [服务提供者:provider 集群第二节点] 
#### 安装Nacos
+ [下载地址](https://github.com/alibaba/nacos/releases)
+ 解压并执行: 安装到我的电脑上(E:\WorkTool\nacos\nacos)
    ```text
    Linux/Unix/Mac：sh startup.sh -m standalone
    Windows：cmd startup.cmd -m standalone
    ```
+ 访问：http://127.0.0.1:8848/nacos/  默认用户名密码为：nacos
+ 停止nacos服务:
  ```text
    # Linux/Unix/Mac
    sh shutdown.sh
    # Windows
    cmd shutdown.cmd
  ```
#### 注册服务到nacos上  
+ 新建一个服务发现的生产者: ali-nacos-discovery-server  [这个是服务提供者]
+ 启动application的时候【日志虽然有报错,但不影响服务的注册到nacos上】，查看nacos中的 【服务列表】 有【2个节点】,相应服务名称 【ali-nacos-discovery-server】 是处于正常的健康状态
+ 访问: localhost:7700/hello?name=samlai  [正常的访问]