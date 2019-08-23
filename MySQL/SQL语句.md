# MySQL中的基本操作

**1、数据定义**

~~~sql
--展示所有的数据库
show databases;       

--创建数据库
create database 数据库名;

--删除数据库
drop database 数据库名;

--切换数据库
use 数据库名;

--查看当前数据库中，所有的表
show tables;

--查看数据库表的表结构
desc 表名;

--创建表和 SqlServer 一样，自增可以使用auto_increment

--显示建表语句
show create table 表名;

--添加外键
alter table pet add constraint fk_pet_mid foreign key(mid) references master(mid);

--删除外键（需要使用foreign key，而不是使用constraint）
alter table pet drop foreign key fk_pet_mid;

--添加违约处理（删除时将值设为空，更新时级联操作）
alter table pet add constraint fk_pet_mid foreign key(mid) references master(mid) on delete set null on update cascade;
~~~

> 注意：
>
> * 在 MySQL 中，语句必须以分号结尾
>
> * 自增字段，可以设为null，默认自增，省略
>
> * 日期的表达方式：
>
>   YYYY-MM-DD
>
>   YYYY/MM/DD
>
>   sysdate（）表示系统当前的时间
>
>   now（）也表示系统当前的时间
>
> * 注意在删除外键的时候与SqlServer的区别

**2、数据查询**

~~~sql
--单表查询，与SqlServer相似

--连接查询，同样和SqlServer一样，但是不支持全外连接，可以使用并运算实现
--自然连接
select * from master join pet on master.mid = pet.mid;

--左外连接
select * from master left join pet on master.mid = pet.mid;

--右外连接
select * from master right join pet on master.mid = pet.mid;

--分页查询（第一个表示数据的索引，从 0 开始，第二个表示显示的数据的条数）
select * from help_category limit 10, 5;
~~~

> 注意：
>
> - 在连接查询中，可以不使用 outer 关键字，SqlServer 也可以不使用

**3、数据更新**

~~~sql
--插入，更新，修改和 SqlServer 类似，不同的地方是，在插入的过程中，MySQL 支持一条 inset 插入多行
insert into 表名 values(一行), (二行), (三行) . . .;
~~~

**4、数据控制**