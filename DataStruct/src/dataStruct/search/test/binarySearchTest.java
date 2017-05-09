package dataStruct.search.test;

import java.util.Scanner;

import dataStruct.search.Search;
import dataStruct.sort.KeyType;
import dataStruct.sort.RecordNode;
import dataStruct.sort.SeqList;

/**
 * 二分查找测试程序
 * @author 范立炎
 * @时间 2017-05-09
 *
 */
public class binarySearchTest {

	static Search ST = null;
	
	public static void createSearchList() throws Exception{
		int maxSize = 20;			//查找表预分配空间的大小
		ST = new Search(maxSize);			//创建查找表对象
		int curlen;				//查找表的实际长度
		System.out.println("Please input table length:");
		Scanner sc = new Scanner(System.in);
		curlen = sc.nextInt();
		KeyType[] k = new KeyType[curlen];
		System.out.println("Please input keyword sequence:");
		for(int i = 0; i < curlen; i++){     //输入关键字序列
			k[i] = new KeyType(sc.nextInt());
		}
		for(int i = 0; i < curlen; i++){    //记录顺序表
			RecordNode r = new RecordNode(k[i]);
			ST.insert(ST.length(), r);
		}
	}
	
	public static void main(String[] args) throws Exception {
			createSearchList();      //创建查找表
			System.out.println("please input search keyword:");   //提示输入待查找的关键字
			Scanner sc = new Scanner(System.in);
			KeyType key1 = new KeyType(sc.nextInt());        //输入待查找关键字
			KeyType key2 = new KeyType(sc.nextInt());
			System.out.println("binaryseqSearch(" + key1.key + ")=" + ST.binarySearch(key1));
			System.out.println("binaryseqSearch(" + key2.key + ")=" + ST.binarySearch(key2));
			
	}

}
