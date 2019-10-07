# Java 中的代理模式

## 一、代理模式介绍

[代理模式](https://zh.wikipedia.org/wiki/%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F) 是一种设计模式，提供了对目标对象额外的访问方式，即通过代理对象访问目标对象，这样可以在不修改原目标对象的前提下，提供额外的功能操作，扩展目标对象的功能。

简言之，代理模式就是设置一个中间代理来控制访问原目标对象，以达到增强原对象的功能和简化访问方式。

**代理模式的 UML 类图**

![代理模式UML类图](img/18202945_lHIa.png)

举个例子，我们生活中经常到火车站去买车票，但是人一多的话，就会非常拥挤，于是就有了代售点，我们能从代售点买车票了。这其中就是代理模式的体现，代售点代理了火车站对象，提供购买车票的方法。

## 二、静态代理

这种代理方式需要代理对象和目标对象实现一样的接口。

**优点：**可以在不修改目标对象的前提下扩展目标对象的功能。

**缺点：**

- 冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。

- 不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。

**举例：**

定义接口：

~~~java
package com.proxy;

public interface IUserDao {
    public void save();
}
~~~

定义原对象：

~~~java
package com.proxy;

public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
~~~

定义代理对象：

~~~java
package com.proxy;

public class UserDaoProxy implements IUserDao{
    private IUserDao target;
    
    public UserDaoProxy() {
        this.target = new UserDao();
    }
    
    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }
}
~~~

测试类：

~~~java
package com.proxy;

import org.junit.Test;

public class StaticUserProxy {
    @Test
    public void testStaticProxy(){
        //代理对象
        IUserDao proxy = new UserDaoProxy();
        proxy.save();
    }
}
~~~

## 三、动态代理

### 3.1 JDK 动态代理

### 3.2 Cglib 动态代理

