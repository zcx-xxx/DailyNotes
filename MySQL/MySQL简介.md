# MySQL简介

**1. 简介**

所占端口：3306

默认用户：root

**2. MYSQL 的常用命令**

~~~sql
--启动 MySQL 服务
net start mysql57

--停止 MySQL 服务
net stop mysql57

--连接 MySQL
mysql -h(指明主机)127.0.0.1 -u(指明用户)root -p(指明密码)xxx

--退出
exit / quit
~~~

> 本地连接 MySQL 可以不指明主机。

**3. MySQL 的数据类型**

* 数值类型

smallint：2 字节

int：4 字节

Interger（int）：4 字节

bigint：8 字节

float：4 字节

double：8 字节

> 注意：
>
> ​	对于 int(4) 中括号内指定的整数值表示该数据的显示宽度，并不限制该属性列值的取值范围和超过该宽度的值的显示。（相当于起一个格式化的作用）
>
> ​	float(4，1) 表示该小数整数部分加上浮点数部分总共占四位，保留一位小数。

- 字符串类型

char：固定长度，速度快

varchar：可变长度的字符串，处理灵活

text：非二进制大对象，以字符的格式

blob：二进制大对象，非字符的形式

- 日期类型

date：YYYY-MM-DD

time：HH:MM:SS

datetime：YYYY-MM-DD HH:MM:SS

timestamp：YYYY-MM-DD HH:MM:SS

year：YYYY

> 主键自增使用auto_increment