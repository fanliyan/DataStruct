package dataStruct.erchashu.test;

import dataStruct.erchashu.BiTree;

/**
 * �ȸ����и�����һ�ö�������Ȼ�����������
 * @author ������
 *
 */
public class XzCreatBiTree {

	public static void main(String[] args) throws Exception {
			 String preOrder = "ABDEGCFH";    //�ȸ���������
			 String inOrder = "DBGEAFHC";     //�и���������
			 BiTree T = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());   //�����ȸ����и��������д���һ����
			 System.out.println("���������");
			 T.postRootTraverse();      //���ö������ĺ�������ķǵݹ��㷨
	}

}
