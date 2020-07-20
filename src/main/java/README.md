## 初始配置
#### 创建框架

    springWeb
    Thymeleaf
    SpringDev Tool
    Mysql Driver
    JPA
#### Spring配置
日志配置

    - 不同开发环境设置不同的配置（dev、pro）
    - 重写spring框架中的日志配置logback-spring.xml
JPA配置

    - 设置ddl对应规则（不要使用create）
    - 设置sql语句显示
---
## 逻辑设计
#### 日志处理
记录日志内容(Spring AOP)

     - 请求url
     - 访问ip
     - 访问信息（使用方法，参数）
     - 返回内容

## 实体设计（图见clsspng/）
实体类

    博客blog
    博客分类Type
    博客标签Tag
    博客评论Comment
    用户User    
    
    
## 后台管理
1. 登录
  
        登录页面和后台管理页面
        UserService和UserRepository
        LoginController
        MD5加密
        登录拦截