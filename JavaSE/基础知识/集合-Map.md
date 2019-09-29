# 集合-Map

## 1. 基本知识

**1.1 概述**

用来存储键值对，如果键值相同，后边的value将前边的value覆盖

**1.2 主要实现类**

HashMap：底层实现哈希表，查询快，添加快，无序

* key：无序，唯一，即HashSet（HashSet的底层即HashMap，HashSet只使用了HashMap键部分，值部分为一个空对象）

* value：无序，不唯一，Collection

LinkedHashMap：底层结构哈希表+链表，查询快，添加快，有序（添加顺序）

* key：有序（添加顺序），唯一，LinkedHashSet

* value：无序，不唯一，Collection

TreeMap：底层实现红黑树，速度介于哈希表和线性表之间，有序（自然顺序）

* key：有序（自然顺序）唯一，类似 TreeSet

* value：无序，不唯一，Collection

**1.3 对 Map 的遍历**

**将 Map 中的 key 和 value抽取出来**

* key：无序，唯一，即HashSet（HashSet的底层即HashMap，HashSet只使用了HashMap键部分，值部分为一个空对象）、
* value：无序，不唯一，Collection

**对 Map 的遍历**

* 先得到由所有的key组成的set，遍历set的过程中，根据每个key得到所有的value。

~~~java
//得到key的集合
Set<String> keySet = map.keySet();   

//增强for循环遍历set，根据key得到value
for(String key : keySet) {
    System.out.println(map.get(key));
}

//迭代器遍历set,根据key得到value
Iterator<String> it =  keySet.iterator();
while(it.hasNext()) {
    System.out.println(map.get(it.next()));
}
~~~

* 先得到所有的由key-value组成的set，遍历set的过程中，输出每个元素(key-value)的内容。

~~~java
//得到key-value的集合，遍历set
//通过Entry对key-value进行封装，Entry为Map的一个内部集合
Set<Entry<String, String>> entrySet = map.entrySet();
Iterator<Entry<String, String>> itt = entrySet.iterator();

//迭代器
while(itt.hasNext()) {
    Entry<String, String> entry = itt.next();
    System.out.println(entry.getKey() + "is" + entry.getValue());
}

//增强的for循环
for(Entry<String, String> entry : entrySet) {
    System.out.println(entry.getKey() + "ai" + entry.getValue());
}
~~~

