# blogsystem
​    使用SpringBoot搭建的博客管理系统。通过记录审计日志，锁等机制维护数据库安全。。

## 一、项目简介



## 二、主要功能



## 三、功能设计详情



## 四、接口设计（与功能设计对应）



## 五、数据库设计

### E-R图

![](D:\study\code\bigtwo\DB\program\BlogSystem\image\E-R.jpg)

1. 用户表（user）：
    - user_id：用户ID，主键
    - username：用户名
    - password：密码
    - email：用户邮箱
    - deleted: 是否删除
    - manger: 是否为管理员
    - create_time：信息创建时间
    - update_time：信息更新时间
2. 博客表（blog）：
    - blog_id：日志ID，主键
    - title：标题
    - content：内容
    - author_id：作者ID，外键，引用用户表（Users）的user_id
    - create_time：博客创建时间
    - update_time: 博客更新时间
3. 用户-博客表（user-blog）
    - user_id：博客作者id
    - blog_id：博客id
    - create_time：创建时间
    - update_time：更新时间
4. 评论表（Comments）：
    - comment_id：评论ID，主键
    - content：评论内容
    - author_id：评论人ID，外键，引用用户表（Users）的user_id
    - blog_id：博客ID，外键，引用博客表（Blog）的blog_id
    - created_time：评论创建时间
    - update_time：评论更新时间
5. 留言表（Messages）：
    - message_id：留言ID，主键
    - content：留言内容
    - user_id: 留言所有者ID，外键，引用用户表（Users）的user_id
    - author_id：留言人ID，外键，引用用户表（Users）的user_id
    - created_time：留言时间
    - update_time：留言更新时间
6. 博友表（Friends）：
    - friend_id：朋友表主键
    - user_id：用户ID，外键，引用用户表（Users）的user_id
    - friend_id：博友ID，外键，引用用户表（Users）的user_id
    - created_time：朋友添加时间
    - update_time：更新时间
