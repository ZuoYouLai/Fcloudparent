### spring-config-client读取server端读取配置文件返回的内容 [资料](http://www.itmuch.com/spring-cloud/finchley-19/) [github地址](https://github.com/eacdy/spring-cloud-study/tree/master/2018-Finchley/microservice-config-client)
+ resources下有2个配置文件:application.yml 与 boostrap.yml
  ```text
    Spring Cloud有一个“引导上下文”的概念，这是主应用程序上下文（Application Context）的父上下文。引导上下文负责从配置服务器加载
  配置属性，以及解密外部配置文件中的属性。和主应用程序加载application.* (yml或properties)中的属性不同，引导上下文加载bootstrap.* 中的
  属性。配置在bootstrap.* 中的属性有更高的优先级，因此默认情况下它们不能被本地配置覆盖。
  ```
+ 访问下:localhost:7991/ 直接访问controller内容测试config-server是否生效  
