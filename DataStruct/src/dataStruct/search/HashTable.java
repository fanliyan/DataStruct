package dataStruct.search;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

/**
 * ��������ַ���Ĺ�ϣ���������롢ɾ�������ҡ��ͱ����Ȳ���
 * @author ������
 * @ʱ�� 2017-05-11
 *
 */
public class HashTable<E> {       //��������ַ���Ĺ�ϣ����

	public LinkList[] table;    //��Ȼ��Ķ�������
	
	public HashTable(int size){     //����ָ����С �Ĺ�ϣ��
		this.table = new LinkList[size];
		for(int i = 0; i < table.length; i++){
			table[i] = new LinkList();        //����յ�����   
		}
	}
	
	public int hash(int key){      //�������෨��ϣ�����������ǹ�ϣ��ĳ���
		return key % table.length;
	}
	
	public void insert(E element) throws Exception{    //�ڹ�ϣ���в���ָ��������Ԫ��
		int key = element.hashCode();        //ÿ�������hashCode()������������ֵ
		int i = hash(key);         //�����ϣ��ַ
		table[i].insert(0, element);
	}
	
	public void printHashTable(){      //�����ϣ���и��������������Ԫ��
		for(int i= 0; i < table.length; i++){
			System.out.println("table[" + i + "]= ");      //�����������������Ԫ��ֵ
			table[i].display();
		}
	}
	
	public Node search(E element) throws Exception{   //�ڹ�ϣ���в���ָ�����������ҳɹ������ؽ�㣻���򷵻�null
		int key = element.hashCode();
		int i = hash(key);
		int index = table[i].indexOf(element);          //��������Ԫ���ڵ������е�λ��
		if(index >= 0){
			return (Node)table[i].get(index);      //�����ڵ��������ҵ��Ľ��
		}else{
			return null;
		}
	}
	
	//�Բ��ҽ���жϹ�ϣ���Ƿ����ָ�����������������򷵻�true; ���򷵻�false
	public boolean contain(E element) throws Exception{
		  return this.search(element ) != null;
	}
	
	//ɾ��ָ��������ɾ���ɹ����򷵻�true,���򷵻�false
	public boolean remove(E element) throws Exception{
		int key = element.hashCode();
		int i = hash(key);
		int index = table[i].indexOf(element);
		if(index >= 0){
			table[i].remove(index);       //�ڵ�������ɾ������
			return true;
		}else{
			return false;
		}
	}
}
