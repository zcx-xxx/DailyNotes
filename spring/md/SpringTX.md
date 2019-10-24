# SpringTx

## 一、Spring 的属性文件注入

- 创建属性配置文件
- 在 Spring 配置文件中声明属性文件扫描
- 在 bean 标签的属性注入中使用 ${ 属性文件键名} 的方式获取数据注入给 bean。

> 注意：
>
> 属性注入级别低于依赖注入。

## 二、Spring 的自动注入

- byName：基于属性名和要注入的 bean 的 id 相同的规则注入

~~~xml
<!-- 配置 Student 对象的 bean -->
<bean id="stu" class="pojo.Student">
    <property name="age" value="20"></property>
    <property name="name" value="zcx"></property>
</bean>

<!-- 配置学生对象的 bean -->
<bean id="tea" class="pojo.Teacher" autowire="byName">
    <property name="age" value="30"></property>
    <property name="name" value="wy"></property>
    <property name="stu" ref="stu"></property>     ------------->   *
</bean>
~~~

> 可以将标注行去掉，会自动根据属性的名字进行查找相应的 bean 对象进行注入。

- byType：基于属性名和要注入的 bean 的类型相同的规则注入
- constructor：基于构造方法的注入方式
- default：全局的注入配置方式
- no：手动注入

## 三、Spring 的 scope 属性

在使用 spring 容器对象在连续获取同一个 bean 多次的时候，在默认的情况下返回的是同一个 bean，相当于是单例模式，如何在每一次获取的时候获取到不同的 bean 对象呢？通过下面的方式：

~~~xml
<bean id="role" class="spring.Role" scope="singleton"/>
~~~

> scope 的取值：
>
> - singleton：单例模式，每次获取都返回同一个实例，相对于同一个IOC容器而言。
>
> - prototype：原型模式，每次获取返回不同实例，创建后的生命周期不再由IOC容器管理。
>
> - request：作用域为同一个 Http Request。
>
> - session：作用域为同一个 Http Session。
>
> - application：作用域为同一个WEB容器，可以看做Web应用中的单例模式。
>
> - websocket：作用域为同一个WebSocket应用。

## 四、Spring 中的注解

### 4.1 注解的作用

替换配置文件的配置信息，提高开发的效率

### 4.2 注解的使用

- 在 spring 的配置文件中声明声明注解扫描
- 使用注解替换 xml 配置

### 4.3 Spring 中的注解

**bean 注解：**

@compent：使用在普通类上，相当于将其配置为 Bean 对象

@service：生命在业务层对象上，相当于配置为 bean 对象

@controller：生命在控制器类上，想当于声明为 bean 对象

> 注意：
>
> 都是配为 bean 对象，只是类的功能不一样，所以区分一下。

**依赖注入注解：**

@AutoWire：声明在要被依赖注入的引用类型的属性上，默认使用 byType 的方式

@Resource：声明在要被依赖注入的引用类型的属性上，默认使用 byName 的方式，如果不能找到，使用 byType

**属性文件注入方式：**

@value：声明在实体类的属性上。

> @AutoWire、@Resource、@value均不需要提供 get/set方法。

**AOP 注解：**

@Aspctj

@PointCut

@Before

@After

@AfterReturning

@Around