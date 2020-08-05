# MyBlog
🌍
基于`SpringBoot` `JPA` `Semantic UI`搭建的个人博客

参照[这位大佬的博客教程及源码]，对前端页面进行改造，制作出适合自己的前端页面。

## 前端
- 采用Semantic UI模板制作前端页面
- 前端页面的属性分析详见静态文件夹中的[README](src/main/resources/前端页面设计.md)
- 主要思路：设计一个简单却不丑陋的前端页面，可以尽快的加入后端，
			日后可以对前端进行升级改造。
				
> 插件集成：
>
    - 编辑器Markdown   https://pandao.github.io/editor.md/
    - 内容排版typo.css https://github.com/sofish/Typo.css
    - 动画animate.css https://animate.style/
    - 代码高亮prism https://prismjs.com/
    - 滚动侦测waypoints http://imakewebthings.com/waypoints/
    - 平滑滚动jquery.scrollTo  https://github.com/flesler/jquery.scrollTo
    - 目录生成Tocbot https://tscanlin.github.io/tocbot/   正文的标题必须有*id*
    - 二维码生成qrcode.js http://davidshimjs.github.io/qrcodejs/
       
    - markdown转htmlcommonmark-java

## 后端
- 具体设计可以查看逻辑包内的[README](src/main/java/README.md)

        - 核心框架：SpringBoot 2.x
        - 项目构建：jdk1.8、Maven 3
        - 持久层框架：JPA
        - 模板框架：Thymeleaf
        - 分页插件：PageHelper
        - 加密：MD5加密
        - 运行环境：

## 数据库 
    - Mysql 5.7

## TODO
    - 其他页面都应用blog的弹窗设定
    - 各个界面的动画设置https://animate.style/
    - 可以利用滚动检测插件制作定位弹窗等.http://imakewebthings.com/waypoints/
    - 滚动侦测可以添加动画让弹窗更丝滑(侧边目录弹窗)
	- 评论插件
	- 安全管理shiro
	- 分页管理PageHelper
	- 添加博客时的标签自动添加
	- 全局搜索可以改用ElasticSearch
	
	-部署后二维码的域名设置
    
[这位大佬的博客教程及源码]:https://www.cnblogs.com/one-star/category/1772840.html