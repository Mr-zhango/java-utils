package cn.myfreecloud.javautils.collection;

/**
 * Collection 接口:单列接口，有两个子接口
 * 1.List接口
 * 有三个实现类（LinkedList，ArrayList，Vector）
 *      a.LinkedList:基于链表实现，每一个元素存储本身内存地址的同时还存储下一个元素的地址。链表增删快，查询慢
 *      b.ArrayList:基于数组实现，每次增删都要创建新的数组，但数组有索引。增删慢，查找快。
 *      c.Vector：基于数组实现，线程安全的，效率低
 * 2.Set接口
 * 有两个实现类（HashSet，LinkedHashSet）
 *      a.HashSet 无序，不可重复，底层是哈希表
 *      b.LinkedHashSet 存储的元素有序，不可重复，底层是hash表和链表的结合
 * 3.Map接口：双列集合
 * 有三个实现类（HashMap，HashTable，TreeMap）
 *      a.HashMap 非线程安全的，高效，支持null值和null键 有一个子类（LinkedHashMap:保存了记录的插入顺序）
 *      b.HashTable 线程安全的，低效 不支持null
 *      c.TreeMap 能够把它保存的记录根据键值排序，默认是键值得升序
 */
public class CollectionInterfaceDemo {

}
