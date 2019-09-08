# 集合-List

## 1. 基本知识

**1.1 基本概念**

​    对象按索引进行存储，可以存储重复的元素，是有序（添加顺序）的集合（按对象进入的顺序保存对象，不做排序等操作）。

**1.2 基本操作**

- add(int index, Object o)：在指定位置插入元素
- addAll(int index, Collection c)：...
- get(int index)：取得指定位置元素
- indexOf(Obejct o)：返回对象o在集合中第一次出现的位置
- lastIndexOf(Object o)：...
- remove(int index)：删除并返回指定位置的元素
- set(int index, Object o)：替换指定位置元素
- subList(int fromIndex, int endIndex)：返回子集合

**1.3 主要实现类：**

* ArrayList：基于数组实现，线程不安全，性能优于Vector，推荐使用，适用于快速迭代，少量插入删除元素
* LinkedList：基于链表实现，迭代速度缓慢，适用于插入删除频繁的情况
* Vector：基于数组实现，线程安全，性能低于ArrayList，且有好多毛病，不推荐使用

ArrayList：

**1.4 参考文章：**

* [文章1](https://www.cnblogs.com/skywang12345/p/3308556.html#a4)
* [文章2](https://www.cnblogs.com/aoguren/p/4771589.html)

##  2. 具体分类

### 2.1 ArrayList

**2.1.1 ArrayList概述**

* 底层：ArrayList底层是一个可变长的数组，连续的空间。
* ArrayList只能保存对象，不能保存基本数据类型，使用泛型可以在写代码的过程中直接存储基本数据类型。
* ArrayList如果在创建对象的时候不使用参数指定其大小，默认初始化大小为10
* 当ArrayList容量不足以容纳全部元素时，ArrayList会重新设置容量：新的容量=“(原始容量x3)/2 + 1”。
* ArrayList的克隆函数，即是将全部元素克隆到一个数组中。
* ArrayList不适合插入或删除元素，会造成元素的大量后移，效率极其低下，ArrayList适合于元素访问频繁的情况。
* ArrayList不能使用中括号加下标进行访问。

**2.1.2 三种遍历方式**

* for循环（效率最高）

* forEach，增强for循环（注：增强for循环可以修改数据，但是不能删除数据）（效率最低）

* 迭代器（效率其次）

**2.1.3 代码**

~~~java
package TestArrayList;
import java.util.ArrayList;
import java.util.Iterator;
public class TestArrayList {
    public static void main(String[] args) {
        //创建一个ArrayList，使用了泛型
        ArrayList <Integer>list = new ArrayList <Integer>();
        ArrayList <Integer>list2 = new ArrayList<Integer>();
        
        list2.add(1);
        list2.add(1);
        list2.add(1);
        
        //添加元素，因为使用了泛型，所以没有给出警告，如果不使用泛型会有警告
        list.add(45);            //自动装箱
        list.add(55);            //自动装箱
        list.add(66);            //自动装箱
        
        //获取有效元素的个数
        System.out.println(list.size());     
        
        //[45, 55, 66],默认调用了ArrayList的toString()方法
        System.out.println(list);     
        
        //转数组
        System.out.println(list.toArray()[1]);
        
        //返回ArrayList指定下标的数组元素
        System.out.println(list.get(0));    
        
        //指定的位置添加元素
        list.add(1, 100);            
        System.out.println(list);
        
        //默认在末尾添加大量的元素
        list.addAll(list2);
        //在指定的位置添加大量的元素
        list.addAll(1, list2);      
        System.out.println(list);
        
        //判空
        list.isEmpty();
        
        //判断是否包含指定的元素
        System.out.println(list.contains(100));
        
        //修改指定位置的元素的值
        list.set(1, 777);
        System.out.println(list);
        
        //使用迭代器遍历数组
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {              //判断是否还有下一个元素
           System.out.println(it.next());   //先指针后移，再返回前一个元素
        }
        
        //返回指定元素的下标，找不到返回-1
        System.out.println(list.indexOf(777));
        
        //删除指定下标的元素
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        
        //删除指定的内容
        list.remove(new Integer(66));
        System.out.println(list);
        //排序，先实例化一个比较器对象
        MyCompare cmp = new MyCompare();
        Collections.sort(list, cmp);
        System.out.println(list);
    }
}
//自定义比较器
class MyCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        int a = o1;
        int b = o2;
        
        if(a < b) {
           return 1;
        } else if(a > b) {
           return -1;
        } else {
           return 0;
        }
    }
}
/*
 * ArrayList：集合：只能放对象，不能放基本数据类型
 * 底层实现：一个可以动态扩容的数组
 *
 * 添加元素：
 * add()，每次添加一个元素，会判断内存是否足够，不够自动扩容
 * list.add(index, Integer);在指定的位置插入一个元素
 * list.addAll(Collection);  默认在末尾进行添加
 * list.addAll(index, Collection);   在指定的位置进行添加
 *
 * 获取有效元素的个数：
 * size()，底层有一个size变量记录有效元素的个数，初始化为0，每次添加元素，size++
 *
 * 返回一个以ArrayList中的元素为内容的数组：
 * toArray()，由于会重新分配数组的空间，所以可以对返回的数组进行修改
 *
 * 获取指定下标的元素：
 * get()，随机访问
 *
 * 判空：
 * list.isEmpty(),判断size是否为 0
 *
 * 判断是否包含指定的元素：
 * list.contains() 返回值true/false
 *
 * 修改指定下标的元素：
 * list.set(index, Integer);
 *
 * 遍历：
 * 1.for循环
 * 2.for-Each
 * 3.Iterator迭代器
 *
 * 找元素：
 * list.indexOf();    查找指定元素的下标，找不到返回-1
 *
 * 删指定下标的元素：
 * list.remove(index),     删除指定的下标的元素,
 * 注：由于元素类型为int，下标也为int，所以默认参数默认理解为下标，想实现根据内容删除，传入一个对象
 *
 * */
~~~

### 2.2 LinkedList

**2.2.1 LinkedList概述**

* 底层实现：**双向链表，增加了对链表的首尾进行操作的方法**，它也可以被当作堆栈、队列或双端队列进行操作。LinkedList随机访问效率低，但随机插入、随机删除效率低。
* .与ArrayList的基本操作相同。只是增加了一些操作
* 初始化容量为0

**2.2.2 代码**

~~~java
import java.util.LinkedList;
import java.util.List;
public class TestLinkEdList {
    public static void main(String[] args) {
        //向上转型
        List<Integer> list = new LinkedList<Integer>();
        
        //添加
        for(int i = 0; i < 5; ++i) {
           list.add(i);
        }
        
        //访问指定位置的元素
        for(int i = 0; i < list.size(); ++i) {
           System.out.println(list.get(i));
        }
        
        //向下转型，首部添加(LinkedList新增的方法)
        LinkedList<Integer> list1 = (LinkedList<Integer>)list;
        
        //首部添加(LinkedList新增的方法)
        list1.addFirst(100);
        //首部移除
        list1.removeFirst();
        //末尾添加
        list1.addLast(100);
        //末尾移除
        list1.removeLast();
        //获得第一个节点
        list1.getFirst();
        //获得最后一个节点
        list1.getLast();
    }
}
~~~

