package dataStruct.erchashu.test;

import dataStruct.erchashu.BiTree;
import dataStruct.erchashu.BiTreeNode;

public class Exam5_7 {

	//��˳��洢����ȫ����������һ�ö�����������index��ʶ�������˳��洢�ṹ�е�λ��
	public BiTreeNode createBiTree(String sqBiTree, int index){
		BiTreeNode root = null;   //�����
		if(index < sqBiTree.length()){   //λ�ò�Խ��
			root = new BiTreeNode(sqBiTree.charAt(index));   //�������ĸ���㣬�洢������ʹ����0�ŵ�Ԫ
			root.lchild = createBiTree(sqBiTree, 2 * index + 1);   //��������������
			root.rchild = createBiTree(sqBiTree, 2 * index + 2);    //��������������
		}
		return root;
	}
	public static void main(String[] args) throws Exception {
		Exam5_7 e = new Exam5_7();
		String sqBiTree = "ABCDEFGH";    //˳��洢����ȫ������
		BiTreeNode root = e.createBiTree(sqBiTree, 0);
		BiTree T = new BiTree(root);
		System.out.println("�и�������");
		T.inRootTraverse();
		System.out.println();
	}

}
