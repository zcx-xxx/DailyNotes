# 集合-Set

## 1. 基本知识

**1.1 Set概述**

* Set集合不允许包含相同的元素，而判断两个对象是否相同则是根据equals方法。

* Set的底层实现是Map，相当于只使用了Map的键部分

**1.2 主要实现类**

- HashSet：底层实现：哈希表

  优点：添加速度快，查询速度快，删除速度快

  缺点：无序（指添加顺序），无重

  集合元素值可以是null。

- LinkedHashSet：底层实现：哈希表+链表，链表用于维护次序（添加顺序），效率稍慢于HashSet

- TreeSet：底层实现：红黑树，调用的是TreeMap

  优点：有序（自然顺序），查询速度比list快（按照内容进行查询），唯一

  缺点：查询速度没有HashSet快

**1.3 集合的查找速度（按内容查找）**

* 最慢：数组

* 较快：树

* 最快：HashSet

**1.4 Set 的遍历**

* 增强的 for 循环
* 迭代器

**1.5 代码**

~~~java
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class TestSet {
    public static void main(String[] args) {
//      Set<String> set = new HashSet<String>();
        Set<String> set = new TreeSet<String>();
//      Set<String> set = new LinkedHashSet<String>();
        
        set.add("java");
        set.add("数据结构");
        set.add("html");
        set.add("oracal");
        
        //遍历,增强的for循环
        for(String course:set) {
           System.out.println(course);
        }
        
        //迭代器
        Iterator<String> it = set.iterator();
        
        while(it.hasNext()) {
           System.out.println(it.next());
        }
    }
}
~~~

> 注意：
>
> * 如果将元素放入HashSet和LinkedHashSet等底层结构为哈希表的集合中，必须重写两个方法equals()和hashCode()


