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
        MD5加密(最好在前端登录框就进行加密)
        登录拦截
      
2. 分类
        
        分类页面
        分类列表分页
        分类增删改
        
3. 标签
        
        与分类相同
        
4. 博客管理
    
        发布
        修改
        删除
        分页查询
        
## 前端展示（自动获取最新）

    博客列表
    top分类
    top标签
    最新博客推荐
    博客详情
    搜索相关内容
        
## 评论功能
    
    评论信息提交与回复
    评论信息列表展示
    管理员回复评论