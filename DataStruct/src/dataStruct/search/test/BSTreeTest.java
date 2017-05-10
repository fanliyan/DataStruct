package dataStruct.search.test;

import dataStruct.search.BSTree;
import dataStruct.sort.ElementType;
import dataStruct.sort.KeyType;
import dataStruct.sort.RecordNode;

/**
 * �������������Գ���
 * @author ������
 * @ʱ�� 2017-05-10
 *
 */
public class BSTreeTest {

	public static void main(String[] args) {
		BSTree bstree = new BSTree();
		int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};   //�ؼ�����
		String[] item = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou"};    //����Ԫ��
		KeyType[] key = new KeyType[k.length];        //�ؼ�������
		ElementType[] elem = new  ElementType[k.length];       //��¼��������
		System.out.println("ԭ���У�");  
		for(int i = 0; i < k.length; i++){
			key[i] = new KeyType(k[i]);     //�����ؼ��ֶ���
			elem[i] = new ElementType(item[i]);     //������¼���ݶ���
			if(bstree.insertBST(key[i], elem[i])){    //���������ɹ�
				System.out.println("[" + key[i] + "," + elem[i] + "]");
			}
		}
		System.out.println("\n�������������������");
		bstree.inOrderTraverse(bstree.root);
		System.out.println();
		KeyType keyvalue = new KeyType();
		keyvalue.key = 63;
		RecordNode found = (RecordNode)bstree.searchBST(keyvalue);
		if(found != null){
			System.out.println("���ҹؼ��룺" + keyvalue + ",�ɹ�����Ӧ����Ϊ��" + found.element);
		}else{
			System.out.println("���ҹؼ��룺" + keyvalue + ",ʧ�ܣ�");
		}
		keyvalue.key = 39;
		found = (RecordNode)bstree.searchBST(keyvalue);
		if(found != null){
			System.out.println("���ҹؼ��룺" + keyvalue + ",�ɹ�����Ӧ����Ϊ��" + found.element);
		}else{
			System.out.println("���ҹؼ��룺" + keyvalue + ",ʧ�ܣ�");
		}
		keyvalue.key = 13;
		found = (RecordNode)bstree.removeBST(keyvalue);
		if(found != null){
			System.out.println("ɾ���ؼ��룺" + keyvalue + ",�ɹ�����Ӧ����Ϊ��" + found.element);
		}else{
			System.out.println("ɾ���ؼ��룺" + keyvalue + ",ʧ�ܣ�");
		}
		System.out.println("\nɾ���ؼ��룺" + keyvalue + " ��������������:");
		bstree.inOrderTraverse(bstree.root);
		System.out.println();
	}
}
