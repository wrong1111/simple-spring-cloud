# simple-spring-cloud
spring-cloud模块的应用

springbootadmin版本 

springcloud Dalston.SR3
    springboot 1.5.4
    spring-boot-admin-server 1.5.4
    spring-boot-admin-server-ui 1.5.4
 其他版本会报  ClassNotFoundException for "org.springframework.cloud.netflix.zuul.ZuulServerAutoConfiguration"
 
 
 1.simple-config-server 
 配置svn时，注意参数 default-label 是 server.default-label.
 default-lable=trunk时，一定要在指定的URL目录下有此目录，否则会提示 no label found trunk
 
 其他应用使用注册中心配置参数时，需要定义在 bootstrap.properites文件中
 示例
 #此处定义的config.name 是对外访问 .如下示例为http://app:port/config/dev,访问的具体文件为 config-dev.properties
 spring.cloud.config.name=config
 spring.cloud.config.profile=dev
 spring.cloud.config.uri=http://111.11.2.1:28004/
 ##git 配置默认lable为master
 #spring.cloud.config.label=master
 
 ## svn 配置默认为trunk
 spring.cloud.config.label=trunk
 spring.cloud.config.discovery.service-id=spring-cloud-config-server
 
 2,使用注册中心刷新 @RefreshScope时，与robin定义的restTemplate 产生冲突，需要分开使用。
 
