# 相关操作

## 1. 修改 MySQL 的端口

* 登录 MySQL

* 查询当前的端口

  ~~~sql
  show variables like 'port';
  ~~~

* 修改端口：

  修改 /etc/my.cnf 下的文件。该文件可能只是一个链接文件，编辑其 指向的文件。

* 重新启动 MySQL：

  ```
  service mysql restart
  ```

* 再次登录查看

## 2. 开启 Binlog 和数据库备份

[链接1：](https://blog.belonk.com/c/mysql_binlog_backup.html)

## 3. 数据备份

[链接1：](https://www.jianshu.com/p/c3d8366326c1)