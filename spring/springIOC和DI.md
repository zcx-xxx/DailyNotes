# 使用 spring 创建对象

## 一、使用 SpringIOC 创建对象的三种方式

使用 spring 容器创建对象主要有三种方式：

- 使用构造器
- 使用工厂的方式
- 属性注入：首先创造空的对象，然后调用 set 方法对属性进行赋值。

> 以上三种创建对象的方式，是让 spring 容器根据配置文件创建带有固定的初始化参数的对象。

### 1.1 使用构造器的方式创建对象

applicationContext.xml 文件

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 配置无参构造器 -->
    <bean id="u1" class="pojo.User"></bean>
    
    <!-- 配置带参数的构造器 -->
    <bean id="u2" class="pojo.User">
    	<constructor-arg index="0" name="uid" type="int" value="20"></constructor-arg>
    	<constructor-arg index="1" name="name" type="String" value="zcx"></constructor-arg>
    </bean>

</beans>
~~~

> index：参数的下标，从 0 开始
>
> name：参数的名字
>
> type：参数的类型
>
> value：参数的值
>
> 一个 constructor-arg 指定一个参数。

### 1.2 使用工厂的方式创建对象

applicationcontext.xml

~~~xml
<!-- 配置静态工厂  -->
<bean id="uf" class="pojo.UserFactory" factory-method="newInstance"></bean>    

<!-- 配置动态工厂  -->
<bean id="uf2" class="pojo.UserFactory2"></bean>
<bean id="u4" class="pojo.Student" factory-bean="uf2" factory-method="newInstance"></bean>  
~~~

> 静态工厂：即调用工厂类的静态方法生产的对象
>
> - 配置：
>
>   factory-method：产生对象的静态方法
>
> 动态工厂：生产对象的方法是非静态的，需要首先获得工厂的实例化对象，然后在调用该对象用于生产对象的方法实例化对象。
>
> * 配置：
>
>   factory-bean：产生对象所需要的工厂。
>
>   factory-method：工厂中用于产生对象的非静态方法。
>
> **作用：**实现了生产对象的过程和代码的解耦。

### 1.3 属性注入的方式创建对象

applicationcontext.xml

~~~xml
<!-- 采用属性注入的方式创建对象 -->
<bean id="u5" class="pojo.User">
    <!-- 设置基本类型的数据 -->
    <property name="uid" value="20"></property>
    <property name="name" value="lisi"></property>

    <!-- 数组类型 -->
    <property name="arr">
        <array>
            <value></value>
            <value></value>
            <value></value>
        </array>
    </property>
</bean> 
~~~

> 相当于首先创建一个空对象，然后使用 property 为属性赋值，底层拼接 set 方法。

## 二、依赖注入

### 2.1 基于构造函数的依赖注入

~~~xml
<!-- 配置 Teacher 的 bean -->
<bean id="tea" class="pojo.Teacher">
    <constructor-arg index="0" type="int" name="age" value="50"></constructor-arg>
    <constructor-arg index="1" type="String" name="name" value="wy"></constructor-arg>
    <constructor-arg index="2" type="pojo.Student" name="stu" ref="stu"></constructor-arg>
</bean>
<!-- 配置 Student 的 bean -->
<bean id="stu" class="pojo.Student">
    <constructor-arg index="0" type="int" name="age" value="20"></constructor-arg>
    <constructor-arg index="1" type="String" name="name" value="zcx"></constructor-arg>
</bean>
~~~

> * 和上边创建对象的三种方式几乎一致，唯一的不同便是可以给自己定义的引用类型进行赋值，使用 ref 属性。
> * bean 的配置顺序是无所谓的。

### 2.2 基于属性注入的依赖注入

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
        
        <!-- 配置 Student 对象的 bean -->
        <bean id="stu" class="pojo.Student">
        	<property name="age" value="20"></property>
        	<property name="name" value="zcx"></property>
        </bean>
        
        <!-- 配置学生对象的 bean -->
        <bean id="tea" class="pojo.Teacher">
        	<property name="age" value="30"></property>
        	<property name="name" value="wy"></property>
        	<property name="stu" ref="stu"></property>
        </bean>
</beans>
~~~

## 三、创建对象

在测试代码中创建对象：

~~~java
public class Test {
	
	public static void main(String[] args) {
        //创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
        
        //通过容器对象获得 Demo 类的实例
		Demo d = (Demo) ac.getBean("demo1");
		d.demo();
	}
}
~~~

