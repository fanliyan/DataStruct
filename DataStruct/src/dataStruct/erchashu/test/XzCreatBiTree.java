package dataStruct.erchashu.test;

import dataStruct.erchashu.BiTree;

/**
 * 先根和中根遍历一棵二叉树，然后后根遍历输出
 * @author 范立炎
 *
 */
public class XzCreatBiTree {

	public static void main(String[] args) throws Exception {
			 String preOrder = "ABDEGCFH";    //先根遍历序列
			 String inOrder = "DBGEAFHC";     //中根遍历序列
			 BiTree T = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());   //根据先根和中根遍历序列创建一棵树
			 System.out.println("后根遍历：");
			 T.postRootTraverse();      //调用二叉树的后根遍历的非递归算法
	}

}
