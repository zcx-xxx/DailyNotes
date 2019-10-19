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

在 spring 中 jdk 动态代理是基于接口的，原理和静态代理类似。

![jdkporexy](img\jdkporexy.png)

#### 3.1.1 例子：

**首先定义自己的要被代理的类及其接口：**

接口：

~~~java
/**
 * @Title: PersonInterface.java
 * 接口
 */
package jdkproxy;

public interface PersonInterface {
	public void eat();
}
~~~

具体的实现类：

~~~java
package jdkproxy;

/**
 * @ClassName: Person
 * @Description: 具体的实现类
 */
public class Person implements PersonInterface{

	/* (非 Javadoc)
	 * <p>Title: eat</p>
	 * <p>Description: </p>
	 * @see jdkproxy.PersonInterface#eat()
	 */
	@Override
	public void eat() {
		System.out.println("吃");
	}
}
~~~

**定义代理类，实现 InvocationHandler 接口：**

~~~java
package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: MyJdkProxy
 * @Description: 
 * @author 13071
 * @date 2019年10月11日
 *
 */
public class MyJdkProxy implements InvocationHandler {
	private PersonInterface personInterface;
	/** 
	 * 创建一个新的实例 MyJdkProxy.
	 * 传入被代理类的实例化对象，指定哪一个对象调用 invoke 方法
	 */
	public MyJdkProxy(PersonInterface personInterface) {
		this.personInterface = personInterface;
	}

	/* (非 Javadoc)
	 * <p>Title: invoke</p>
	 * <p>Description: </p>
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("吃饭之前先洗手");
		
        //调用 invoke 方法
		method.invoke(personInterface, args);
		
		System.out.println("吃晚饭洗漱睡觉");

		return null;
	}
}
~~~

> invoke 方法的三个参数：
>
> * proxy：传入的代理类对象
> * method：代理类对象要进行扩展的方法。
> * args：扩展方法需要的参数。

**测试类：**

~~~java
public class TestProxy {
	public static void main(String[] args) {
		PersonInterface person = (PersonInterface) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[] {PersonInterface.class}, new MyJdkProxy(new Person()));
		person.eat();
	}
}
~~~

> Proxy.newProxyInstance 的三个参数：
>
> * 类加载器：随便一个就行
> * 被代理类所实现的接口
> * 代理类的实例化对象

#### 3.1.2 大致原理

* 首先使用类加载器通过传入的接口类信息实例化一个实现了该接口的对象。
* 该对象中有一个 InvocationHandler 类型的引用，通过传入自己实现的代理对象进行初始化。（即MyJdkProxy）
* 在 eat() 方法中调用自己定义的代理类中的 invoke 方法。

~~~java
public class InstancePerson implements PersonInterface{
	private InvocationHandler invocationHandler;
	/* (非 Javadoc)
	 * <p>Title: eat</p>
	 * <p>Description: </p>
	 * @see jdkproxy.PersonInterface#eat()
	 */
	@Override
	public void eat() {
		invocationHandler.invoke(Object xxx, method xxx, Params[] args);
	}
}
~~~

### 3.2 Cglib 动态代理

#### 3.2.1 介绍

CGLIB(Code Generation Library)是一个开源项目！是一个强大的，高性能，高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口。Hibernate用它来实现PO(Persistent Object 持久化对象)字节码的动态生成。

CGLIB是一个强大的高性能的代码生成包。它广泛的被许多AOP的框架使用，例如Spring AOP为他们提供方法的interception（拦截）。CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。

除了CGLIB包，脚本语言例如Groovy和BeanShell，也是使用ASM来生成java的字节码。当然不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。

#### 3.2.2 例子

**业务类：**

~~~java
package com.lanhuigu.spring.proxy.cglib;
 
public class HelloService {
 
    public HelloService() {
        System.out.println("HelloService构造");
    }
 
    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>"+name);
        return null;
    }
 
    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }
}
~~~

**自定义MethodInterceptor：**

~~~java
package com.lanhuigu.spring.proxy.cglib;
 
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
 
import java.lang.reflect.Method;
 
/**
 * 自定义MethodInterceptor
 */
public class MyMethodInterceptor implements MethodInterceptor{
 
    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * objects：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("======插入后者通知======");
        return object;
    }
}
~~~

**生成CGLIB代理对象调用目标方法：**

~~~java
package com.lanhuigu.spring.proxy.cglib;
 
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
 
public class Client {
    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        HelloService proxy= (HelloService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();
    }
}
~~~

