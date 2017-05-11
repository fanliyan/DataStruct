package dataStruct.search.test;

import dataStruct.search.HashTable;

/**
 * 链表地址法测试程序。哈希表的查找、插入和删除操作的测试
 * @author 范立炎 
 * @时间 2017-05-11
 *
 */
public class HashTest {

	
	
	public static void main(String[] args) throws Exception {
          String[] name = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou", "Du"};
          HashTable<String> ht = new HashTable<String>(7);
          
          String elem1, elem2;
          System.out.println("插入元素：");
          for(int i = 0; i < name.length; i++){
        	  ht.insert(name[i]);        //哈希表中插入对象
        	  System.out.println(name[i] + " ");
          }
          System.out.println("\n原哈希表：");
          ht.printHashTable();
          elem1 = name[2];
          System.out.println("查找" + elem1 + "," + (ht.contain(elem1) ? " " : "不") + "成功");
          elem2 = "san";
          System.out.println("查找" + elem2 + "," + (ht.contain(elem2) ? " " : "不") + "成功");
          System.out.println("删除" + elem1 + "," + (ht.remove(elem1) ? " " : "不") + "成功");
          System.out.println("删除" + elem2 + "," + (ht.remove(elem2) ? " " : "不") + "成功");
          System.out.println("新哈希表：");
          ht.printHashTable();
	}
	

}
