###Spring config server [资料](http://www.itmuch.com/spring-cloud/finchley-19/) [配置详情](http://www.itmuch.com/spring-cloud/finchley-20/)  [github地址参考]()
+ [spring cloud生态配置的服务器比较](http://www.itmuch.com/spring-cloud-sum/spring-cloud-config-serer-compare/)
+ 配置git地址 与 git地址目录内容的设置
+ 写上日志的级别:debug 方便查看服务启动是否访问了日志内容
+ 测试访问:localhost:9900/config-test-application.yml  
  ```text
  观察日志与返回结果是否是我们相应配置文件的内容
  1.项目会自动从git下载相应地址的代码内容
  2.然后直接返回配置信息 【测试正确】  
  ```
+ 配置文件应该区分目录进行配置:这样可以区分开项目目录也就是一个项目对应一个项目目录内容 TODO
##### spring config的对称加密与非对称加密
+ spring config有敏感信息,所以需要加上加密信息,使用加密内容与解密内容 [资料](http://www.itmuch.com/spring-cloud/finchley-21/)
  ```text
    对称加密:
    Java 8 JCE的地址：http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
    1 从oracle官网下载JCE ，下载对应JAVA版本的JCE 
    下载地址 
    2 替换JDK 的JRE下的两个Jar文件（%JAVA_HOME%/jre/security）。 
    3 springcloud config-server配置文件中加入encrypt.key=xxxx(自己的加解密key) 
    注意需要配置在bootstrap.yml或bootstrap.application中，不然可能会报No Key的错误 
    4 在postman以POST方式发送http://[ip]:[port]/[context-path]/encrypt requestbody为要加密的内容， 
    也可以使用curl或其他插件post内容 
          这里不能使用浏览器直接访问(POST方式) :
          加密:     localhost:9900/encrypt abc123abc (abc123abc这个是我们需要加密的内容)
          返回结果: 92855844053352e8391a7b7f9bddcfcdcd503ecf74906a3e26446043442d2fd0
        
          解密:     localhost:9900/decrypt 92855844053352e8391a7b7f9bddcfcdcd503ecf74906a3e26446043442d2fd0 (这个是我们需要解密的内容)
          得出 :    abc123abc
      【测试通过】
    5 将git中配置文件加密的内容替换为 {cipher}加密后的内容 
    注意如果配置文件为yml方式，需要加单引号，如果是properties不加
   
    非对称加密方式: 
          参考 ： http://www.itmuch.com/spring-cloud/finchley-21/
          github ： https://github.com/eacdy/spring-cloud-study/tree/master/2018-Finchley/microservice-config-server-encryption-rsa
  ```
#### spring config高可用 [资料](http://www.itmuch.com/spring-cloud/finchley-23/)
  