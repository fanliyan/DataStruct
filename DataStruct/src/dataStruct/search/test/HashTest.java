package dataStruct.search.test;

import dataStruct.search.HashTable;

/**
 * �����ַ�����Գ��򡣹�ϣ��Ĳ��ҡ������ɾ�������Ĳ���
 * @author ������ 
 * @ʱ�� 2017-05-11
 *
 */
public class HashTest {

	
	
	public static void main(String[] args) throws Exception {
          String[] name = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou", "Du"};
          HashTable<String> ht = new HashTable<String>(7);
          
          String elem1, elem2;
          System.out.println("����Ԫ�أ�");
          for(int i = 0; i < name.length; i++){
        	  ht.insert(name[i]);        //��ϣ���в������
        	  System.out.println(name[i] + " ");
          }
          System.out.println("\nԭ��ϣ��");
          ht.printHashTable();
          elem1 = name[2];
          System.out.println("����" + elem1 + "," + (ht.contain(elem1) ? " " : "��") + "�ɹ�");
          elem2 = "san";
          System.out.println("����" + elem2 + "," + (ht.contain(elem2) ? " " : "��") + "�ɹ�");
          System.out.println("ɾ��" + elem1 + "," + (ht.remove(elem1) ? " " : "��") + "�ɹ�");
          System.out.println("ɾ��" + elem2 + "," + (ht.remove(elem2) ? " " : "��") + "�ɹ�");
          System.out.println("�¹�ϣ��");
          ht.printHashTable();
	}
	

}
