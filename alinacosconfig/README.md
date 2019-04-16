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
