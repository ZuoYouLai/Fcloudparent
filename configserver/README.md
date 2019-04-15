###Spring config server [资料](http://www.itmuch.com/spring-cloud/finchley-19/)  [github地址参考]()
+ [spring cloud生态配置的服务器比较](http://www.itmuch.com/spring-cloud-sum/spring-cloud-config-serer-compare/)
+ 配置git地址 与 git地址目录内容的设置
+ 写上日志的级别:debug 方便查看服务启动是否访问了日志内容
+ 测试访问:localhost:9900/config-test-application.yml  
  ```text
  观察日志与返回结果是否是我们相应配置文件的内容
  1.项目会自动从git下载相应地址的代码内容
  2.然后直接返回配置信息 【测试正确】  
  ```
