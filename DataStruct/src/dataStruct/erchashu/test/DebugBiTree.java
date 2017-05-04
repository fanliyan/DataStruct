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
		return new BiTree(a);    //���������Ϊa�Ķ�����
	}
	
	public static void main(String[] args) throws Exception{
		DebugBiTree debugBiTree = new DebugBiTree();
		BiTree biTree = debugBiTree.creatBiTree();
		BiTreeNode root = biTree.getRoot();       //ȡ�����ĸ����
		System.out.print("�ݹ��ȸ���������Ϊ��");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.print("�ǵݹ��ȸ���������Ϊ��");
		biTree.preRootTraverse();
		System.out.println();
		System.out.print("�ݹ��и���������Ϊ��");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.print("�ǵݹ��и���������Ϊ��");
		biTree.inRootTraverse();
		System.out.println();
		System.out.print("�ݹ�����������Ϊ��");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.print("�ǵݹ�����������Ϊ��");
		biTree.postRootTraverse();
		System.out.println();
		System.out.print("��θ���������Ϊ��");
		biTree.levelTraverse();
		System.out.println();
	}
	
}
