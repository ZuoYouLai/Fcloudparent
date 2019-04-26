### Sentinel + Nacos 持久化的使用
#### Nacos
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
#### Sentinel
+ [下载的客户端](https://github.com/alibaba/Sentinel/releases)
+ 运行这个客户端
  ```text
    cd E:\WorkTool\sentinel
    java -jar -Dserver.port=8787 sentinel-dashboard-1.6.0.jar 
    访问: localhost:8787
    默认用户名密码为：sentinel
  ```
+ 启动项目并访问: localhost:7705/hello   

#### 持久化nacos中的数据内容
+ db数据表来源: https://github.com/alibaba/nacos/blob/master/distribution/conf/nacos-mysql.sql
+ 添加到本地的mysql的库中：
  ```text
   1.创建数据库: 
      CREATE DATABASE IF NOT EXISTS nacos DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
   2.再进行执行对应的sql内容:
      nacos-mysql.sql
   3.修改nacos服务的conf目录的application.xml添加如下mysql配置:
     spring.datasource.platform=mysql
     db.num=1
     db.url.0=jdbc:mysql://localhost:3306/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
     db.user=root
     db.password= 
   4.启动nacos服务:
     E:\WorkTool\nacos\nacos\bin
     cmd
     startup.cmd -m standalone
   5.访问：http://127.0.0.1:8848/nacos/  默认用户名密码为：nacos
  ```
#### 启动项目
+ 在nacos项目上配置:
  ```text
    spring:
      application:
        name: ali-sentinel-db-nacos
          
    datasource:
            ds:
              nacos:
                server-addr: localhost:8848
                dataId: ${spring.application.name}-sentinel
                groupId: DEFAULT_GROUP
    需要添加上配置文件的规则内容,在nacos上如下:
    ali-sentinel-db-nacos-sentinel 
    加上如下内容:
    [
        {
            "resource": "/hello",
            "limitApp": "default",
            "grade": 1,
            "count": 5,
            "strategy": 0,
            "controlBehavior": 0,
            "clusterMode": false
        }
    ]
    
    配置说明:
    resource：资源名，即限流规则的作用对象
    limitApp：流控针对的调用来源，若为 default 则不区分调用来源
    grade：限流阈值类型（QPS 或并发线程数）；0代表根据并发数量来限流，1代表根据QPS来进行流量控制
    count：限流阈值
    strategy：调用关系限流策略
    controlBehavior：流量控制效果（直接拒绝、Warm Up、匀速排队）
    clusterMode：是否为集群模式
  ```
+ 访问: localhost:7707/hello  后访问sentinel界面有相应的数据内容  但是没有nacos配置内容  [TODO 实验没有达到nacos配置的规则可以在sentinel进行生效]