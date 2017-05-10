package dataStruct.search.test;

import dataStruct.search.BSTree;
import dataStruct.sort.ElementType;
import dataStruct.sort.KeyType;
import dataStruct.sort.RecordNode;

/**
 * 二叉排序树测试程序
 * @author 范立炎
 * @时间 2017-05-10
 *
 */
public class BSTreeTest {

	public static void main(String[] args) {
		BSTree bstree = new BSTree();
		int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};   //关键数组
		String[] item = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou"};    //数据元素
		KeyType[] key = new KeyType[k.length];        //关键字数组
		ElementType[] elem = new  ElementType[k.length];       //记录数据数组
		System.out.println("原序列：");  
		for(int i = 0; i < k.length; i++){
			key[i] = new KeyType(k[i]);     //创建关键字对象
			elem[i] = new ElementType(item[i]);     //创建记录数据对象
			if(bstree.insertBST(key[i], elem[i])){    //若插入对象成功
				System.out.println("[" + key[i] + "," + elem[i] + "]");
			}
		}
		System.out.println("\n中序遍历二叉排序树：");
		bstree.inOrderTraverse(bstree.root);
		System.out.println();
		KeyType keyvalue = new KeyType();
		keyvalue.key = 63;
		RecordNode found = (RecordNode)bstree.searchBST(keyvalue);
		if(found != null){
			System.out.println("查找关键码：" + keyvalue + ",成功！对应姓氏为：" + found.element);
		}else{
			System.out.println("查找关键码：" + keyvalue + ",失败！");
		}
		keyvalue.key = 39;
		found = (RecordNode)bstree.searchBST(keyvalue);
		if(found != null){
			System.out.println("查找关键码：" + keyvalue + ",成功！对应姓氏为：" + found.element);
		}else{
			System.out.println("查找关键码：" + keyvalue + ",失败！");
		}
		keyvalue.key = 13;
		found = (RecordNode)bstree.removeBST(keyvalue);
		if(found != null){
			System.out.println("删除关键码：" + keyvalue + ",成功！对应姓氏为：" + found.element);
		}else{
			System.out.println("删除关键码：" + keyvalue + ",失败！");
		}
		System.out.println("\n删除关键码：" + keyvalue + " 后的中序遍历序列:");
		bstree.inOrderTraverse(bstree.root);
		System.out.println();
	}
}
