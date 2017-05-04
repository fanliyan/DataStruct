package dataStruct.erchashu.test;

import dataStruct.erchashu.BiTree;
import dataStruct.erchashu.BiTreeNode;

public class Exam5_7 {

	//由顺序存储的完全二叉树建立一棵二叉树，其中index标识根结点在顺序存储结构中的位置
	public BiTreeNode createBiTree(String sqBiTree, int index){
		BiTreeNode root = null;   //根结点
		if(index < sqBiTree.length()){   //位置不越界
			root = new BiTreeNode(sqBiTree.charAt(index));   //建立树的根结点，存储二叉树使用了0号单元
			root.lchild = createBiTree(sqBiTree, 2 * index + 1);   //建立树的左子树
			root.rchild = createBiTree(sqBiTree, 2 * index + 2);    //建立树的右子树
		}
		return root;
	}
	public static void main(String[] args) throws Exception {
		Exam5_7 e = new Exam5_7();
		String sqBiTree = "ABCDEFGH";    //顺序存储的完全二叉树
		BiTreeNode root = e.createBiTree(sqBiTree, 0);
		BiTree T = new BiTree(root);
		System.out.println("中根遍历：");
		T.inRootTraverse();
		System.out.println();
	}

}
