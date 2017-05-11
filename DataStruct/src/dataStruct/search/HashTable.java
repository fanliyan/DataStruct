package dataStruct.search;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

/**
 * 采用链地址法的哈希表，包括插入、删除、查找、和遍历等操作
 * @author 范立炎
 * @时间 2017-05-11
 *
 */
public class HashTable<E> {       //采用链地址法的哈希表类

	public LinkList[] table;    //哗然表的对象数组
	
	public HashTable(int size){     //构造指定大小 的哈希表
		this.table = new LinkList[size];
		for(int i = 0; i < table.length; i++){
			table[i] = new LinkList();        //构造空单链表   
		}
	}
	
	public int hash(int key){      //除数留余法哈希函数，除数是哈希表的长度
		return key % table.length;
	}
	
	public void insert(E element) throws Exception{    //在哈希表中插入指定的数据元素
		int key = element.hashCode();        //每个对象的hashCode()方法返回整数值
		int i = hash(key);         //计算哈希地址
		table[i].insert(0, element);
	}
	
	public void printHashTable(){      //输出哈希表中各个单链表的数据元素
		for(int i= 0; i < table.length; i++){
			System.out.println("table[" + i + "]= ");      //遍历单链表并输出数据元素值
			table[i].display();
		}
	}
	
	public Node search(E element) throws Exception{   //在哈希表中查找指定对象，若查找成功，返回结点；否则返回null
		int key = element.hashCode();
		int i = hash(key);
		int index = table[i].indexOf(element);          //返回数据元素在单链表中的位置
		if(index >= 0){
			return (Node)table[i].get(index);      //返回在单链表中找到的结点
		}else{
			return null;
		}
	}
	
	//以查找结果判断哈希表是否包含指定对象，其他包含，则返回true; 否则返回false
	public boolean contain(E element) throws Exception{
		  return this.search(element ) != null;
	}
	
	//删除指定对象，若删除成功，则返回true,否则返回false
	public boolean remove(E element) throws Exception{
		int key = element.hashCode();
		int i = hash(key);
		int index = table[i].indexOf(element);
		if(index >= 0){
			table[i].remove(index);       //在单链表中删除对象
			return true;
		}else{
			return false;
		}
	}
}
