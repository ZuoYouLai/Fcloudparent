##Spring Cloud Alibaba : conifg 配置中心 【类似于spring config】 [来源](http://blog.didispace.com/spring-cloud-alibaba-3/)
0. 引入依赖:
   ```text
    <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
    </dependency>
   ```
1. 进入Nacos的控制页面，在配置列表功能页面中，点击右上角的“+”按钮，进入“新建配置”页面 配置：gogal.title
2. 通过value获取配置变量
   ```text
    Data ID：填入ali-nacos-config.properties
    Group：不修改，使用默认值DEFAULT_GROUP
    配置格式：选择Properties
    配置内容：应用要加载的配置内容，这里仅作为示例，做简单配置，比如：gogal.title:config-smalai-testing
 
    在value字段读取上配置为: 
    @Value("${gogal.title:}")
    private String title;
 
    读取时日志的打印：
    Located property source: CompositePropertySource {name='NACOS', propertySources=[NacosPropertySource {name='ali-nacos-config.properties'}]}
   ```
3. 配置文件命名一定需要为: bootstrap.properties   不能使用同名的yml文件 这样会无效
4. 请求接口: localhost:7704/test  打印: config-smalai-testing  测试正确
5. 再到nacos上修改配置文件: 打印出 --> config-smalai-testing-lallalallaal啦啦啦啦  测试正确
6. [nacos的配置内容的详解](http://blog.didispace.com/spring-cloud-alibaba-nacos-config-1/)
7. 三种方式的配置内容： [资料](http://blog.didispace.com/spring-cloud-alibaba-nacos-config-2/)
   ```text
    1.DATAID ：
       spring.profiles.active=DEV
       优点：这种方式与Spring Cloud Config的实现非常像，用过Spring Cloud Config的用户，可以毫无违和感的过渡过来，由于命名规则类似，所以要从Spring Cloud Config中做迁移也非常简单。
       缺点：这种方式在项目与环境多的时候，配置内容就会显得非常混乱。配置列表中会看到各种不同应用，不同环境的配置交织在一起，非常不利于管理。
       建议：项目不多时使用，或者可以结合Group对项目根据业务或者组织架构做一些拆分规划
    
    2.GroupID :
       spring.cloud.nacos.config.group=DEV_GROUP
       优点：通过Group按环境讲各个应用的配置隔离开。可以非常方便的利用Data ID和Group的搜索功能，分别从应用纬度和环境纬度来查看配置。
       缺点：由于会占用Group纬度，所以需要对Group的使用做好规划，毕竟与业务上的一些配置分组起冲突等问题。
       建议：这种方式虽然结构上比上一种更好一些，但是依然可能会有一些混乱，主要是在Group的管理上要做好规划和控制。
    
    3.namespace : 当项目较多的时候这种比较合适
       spring.cloud.nacos.config.namespace=83eed625-d166-4619-b923-93df2088883a
       优点：官方建议的方式，通过Namespace来区分不同的环境，释放了Group的自由度，这样可以让Group的使用专注于做业务层面的分组管理。同时，Nacos控制页面上对于Namespace也做了分组展示，不需要搜索，就可以隔离开不同的环境配置，非常易用。
       缺点：没有啥缺点，可能就是多引入一个概念，需要用户去理解吧。
       建议：直接用这种方式长远上来说会比较省心。虽然可能对小团队而言，项目不多，第一第二方式也够了，但是万一后面做大了呢？
    
    注意：不论用哪一种方式实现。对于指定环境的配置（spring.profiles.active=DEV、spring.cloud.nacos.config.group=DEV_GROUP、spring.cloud.nacos.config.namespace=83eed625-d166-4619-b923-93df2088883a）
    都不要配置在应用的bootstrap.properties中。而是在发布脚本的启动命令中，用-Dspring.profiles.active=DEV的方式来动态指定，会更加灵活！。
   ```
 8. 实践:
    ```text
        
        1.DataId : 
          在nacos上配置: 
          A.
          dataId : ali-nacos-config-Test.properties 
          group : DEFAULT_GROUP
          profile=Testing的测试环境          
          
          B.
          dataId : ali-nacos-config-DEV.properties 
          group : DEFAULT_GROUP
          profile=Testing的测试环境
      
           访问:
            localhost:7704/dataId/test
            在启动类中添加 VM options:
            -Dspring.profiles.active=DEV  
                打印: dev开发环境
            -Dspring.profiles.active=Test
                打印: Testing的测试环境
        
        2.GroupID:
          在nacos上配置: 
          A.
          dataId : ali-nacos-config.properties 
          group : DEV_GROUP
          group_name=开发者的分组内容~~~~
          
          B.
          dataId : ali-nacos-config.properties 
          group : TEST_GROUP
          group_name=测试者。。。。。。。测试者
      
          在启动类中添加 VM options:
          -Dspring.cloud.nacos.config.group=DEV_GROUP  
           
        访问:
           localhost:7704/groupId/test
            result:
                开发者的分组内容~~~~
            
          -Dspring.cloud.nacos.config.group=TEST_GROUP   
            result:
                测试者。。。。。。。测试者
          
        3.namespace:
          A.
          DEV:
          dataId : ali-nacos-config.properties 
          group : DEFAULT_GROUP
          namespace=开发者的命名空间 
         
        
          VM option: -Dspring.cloud.nacos.config.namespace=04a9ea11-2b9d-42d5-8241-fc793b9bc4ad
          localhost:7704/namespace/test
          result:
             开发者的命名空间    
        
          B.
          TEST:
          dataId : ali-nacos-config.properties 
          group : DEFAULT_GROUP
          namespace=测试者的命名空间
      
          VM option: -Dspring.cloud.nacos.config.namespace=68fff4ea-a4d3-4fd5-8238-86809af0116e              
          localhost:7704/namespace/test
          result:
             测试者的命名空间       
         
          测试通过~~~
    ```  
9. 多文件进行读取nacos配置 : [资料](http://blog.didispace.com/spring-cloud-alibaba-nacos-config-3/)
    ```text
    使用Nacos配置的时候，主要有以下三类配置：
    A: 通过spring.cloud.nacos.config.shared-dataids定义的共享配置
    B: 通过spring.cloud.nacos.config.ext-config[n]定义的加载配置
    C: 通过内部规则（spring.cloud.nacos.config.prefix、spring.cloud.nacos.config.file-extension、spring.cloud.nacos.config.group这几个参数）拼接出来的配置
    加载的配置会覆盖之前加载的配置，所以优先级关系是：A < B < C
    ```
10. Nacos的数据持久化 [资料](http://blog.didispace.com/spring-cloud-alibaba-4/)    
