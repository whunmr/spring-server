# service-to-service-calls-with-spring-cloud
A repository for a blog on how Spring Cloud promotes resilient service-to-service calls through service registries and service discovery

#演练列表

#1.3  API设计演练
     
     介绍演练需求RDS/EC2
    
      RDS:
       a. 创建RDS实例， 参数包括用户自定义RDS实例名称， 运行实例类型 （db.t1.micro | db.m1.small | db.m1.medium | db.m1.large），数据库引擎（mysql, oracle, sqlserver, postgres), 数据库监听端口
       b. 查询当前所有的RDS实例
       c. 根据传入的RDS实例名称， 查找相应的实例信息
       
    
      EC2：
       a. //TODO: 需求待补充
           


#1.4 API设计演练: Swagger
    将1.3中设计的API列表转换表达成swagger.
    //TODO:    提供一个简化版本的只包括一个写好的uri的swagger的例子
               
               