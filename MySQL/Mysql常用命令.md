# 常用命令

**1. 登录**

~~~sql
mysql -h(主机 ip) -u(username) -p(password)
~~~

> 如果数据库就在当前的主机，可以不指定 -h

**2. 查看所有的数据库**

~~~sql
show databases;
~~~

**3. 查看所有的数据库表**

~~~sql
show tables;
~~~

**4. 查看数据库的版本**

* 登陆时直接查看
* select version();：肯定需要登陆后啊
* status 命令：肯定需要登陆后啊



