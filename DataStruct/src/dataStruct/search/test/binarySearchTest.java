package dataStruct.search.test;

import java.util.Scanner;

import dataStruct.search.Search;
import dataStruct.sort.KeyType;
import dataStruct.sort.RecordNode;
import dataStruct.sort.SeqList;

/**
 * ���ֲ��Ҳ��Գ���
 * @author ������
 * @ʱ�� 2017-05-09
 *
 */
public class binarySearchTest {

	static Search ST = null;
	
	public static void createSearchList() throws Exception{
		int maxSize = 20;			//���ұ�Ԥ����ռ�Ĵ�С
		ST = new Search(maxSize);			//�������ұ����
		int curlen;				//���ұ��ʵ�ʳ���
		System.out.println("Please input table length:");
		Scanner sc = new Scanner(System.in);
		curlen = sc.nextInt();
		KeyType[] k = new KeyType[curlen];
		System.out.println("Please input keyword sequence:");
		for(int i = 0; i < curlen; i++){     //����ؼ�������
			k[i] = new KeyType(sc.nextInt());
		}
		for(int i = 0; i < curlen; i++){    //��¼˳���
			RecordNode r = new RecordNode(k[i]);
			ST.insert(ST.length(), r);
		}
	}
	
	public static void main(String[] args) throws Exception {
			createSearchList();      //�������ұ�
			System.out.println("please input search keyword:");   //��ʾ��������ҵĹؼ���
			Scanner sc = new Scanner(System.in);
			KeyType key1 = new KeyType(sc.nextInt());        //��������ҹؼ���
			KeyType key2 = new KeyType(sc.nextInt());
			System.out.println("binaryseqSearch(" + key1.key + ")=" + ST.binarySearch(key1));
			System.out.println("binaryseqSearch(" + key2.key + ")=" + ST.binarySearch(key2));
			
	}

}
