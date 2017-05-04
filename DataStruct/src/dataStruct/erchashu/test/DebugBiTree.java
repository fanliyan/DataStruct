package dataStruct.erchashu.test;

import dataStruct.erchashu.BiTree;
import dataStruct.erchashu.BiTreeNode;

public class DebugBiTree {

	public BiTree creatBiTree(){
		BiTreeNode d = new BiTreeNode('D');
		BiTreeNode g = new BiTreeNode('G');
		BiTreeNode h = new BiTreeNode('H');
		BiTreeNode e = new BiTreeNode('E', g, null);
		BiTreeNode b = new BiTreeNode('B', d, e);
		BiTreeNode f = new BiTreeNode('F', null, h);
		BiTreeNode c = new BiTreeNode('C', f, null);
		BiTreeNode a = new BiTreeNode('A', b, c);
		return new BiTree(a);    //创建根结点为a的二叉树
	}
	
	public static void main(String[] args) throws Exception{
		DebugBiTree debugBiTree = new DebugBiTree();
		BiTree biTree = debugBiTree.creatBiTree();
		BiTreeNode root = biTree.getRoot();       //取得树的根结点
		System.out.print("递归先根遍历序列为：");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.print("非递归先根遍历序列为：");
		biTree.preRootTraverse();
		System.out.println();
		System.out.print("递归中根遍历序列为：");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.print("非递归中根遍历序列为：");
		biTree.inRootTraverse();
		System.out.println();
		System.out.print("递归后根遍历序列为：");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.print("非递归后根遍历序列为：");
		biTree.postRootTraverse();
		System.out.println();
		System.out.print("层次根遍历序列为：");
		biTree.levelTraverse();
		System.out.println();
	}
	
}
