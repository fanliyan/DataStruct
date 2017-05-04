package dataStruct.danlianbiao;

import java.util.Scanner;

import dataStruct.IXianxingbiao.IList;

/**
 * ��ͷ���
 * @author ������
 *
 */
public class LinkList implements IList {

	public Node head;    
	
	public LinkList() {
		head = new Node();
	}
	
	public LinkList(int n, boolean order) throws Exception{         //���쳤��Ϊn������
		this();           //��ʼ��ͷ���
		if(order){
			createLinkListByTail(n);         //β�巨����������
		}else{
			createLinkListByHead(n); 		//ͷ�巨����������
		}
	}
	
	@Override
	public void clear() {
       head.next = null;
       head.data = null;
	}

	//�жϴ�ͷ���ĵ������Ƿ�Ϊ��
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	//��ͷ��㵥������
	@Override
	public int length() {
		Node p = head.next;    //��ʼ��pΪ�׽��
		int length = 0;   		//������
		while(p != null){
			p = p.next;
			++length;
		}
		return length;
	}

	//��ȡ��ͷ���ĵ�����ĵ�i�����
	@Override
	public Object get(int i) throws Exception {
		Node p = head.next;
		int j = 0;
		while(p != null && j < i){
			p = p.next;
			++j;
		}
		if(j > i || p == null){
			throw new Exception("��" + i + "��Ԫ�ز�����");
		}
		return p.data;
	}

	//��ͷ��㵥����������
	@Override
	public void insert(int i, Object x) throws Exception {
		Node p = head;    //��ʼ��pΪͷ���
		int j = -1;       // jΪ������
		while(p != null && j < i - 1){
			p = p.next;
			++j;
		}
		if(j > i - 1 || p == null){
			throw new Exception("����λ�ò��Ϸ�");
		}  
		Node s = new Node(x);   //�����½��
		s.next = p.next;
		p.next = s;
	}

	//��ȡ��ͷ���ĵ�����ĵ�i�����
	@Override
	public void remove(int i) throws Exception {
          Node p = head; //��ʼ��pΪͷ���
          int j = -1;
          while(p.next != null && j < i - 1){
        	 p = p.next;
        	  ++j;
          }
          if(j > i - 1 || p == null){
        	  throw new Exception("ɾ��λ�ò��Ϸ�");
          }
          p.next = p.next.next;
	}

	@Override
	public int indexOf(Object x) {
		Node p = head.next;
		int j = 0;
		while(p != null && !p.data.equals(x)){
			p = p.next;
			++j;
		}
		if(p != null){
			return j;
		}else{
			return -1;
		}
	}

	@Override
	public void display() {
         Node node = head.next;
         while(node != null){
        	 System.out.print(node.data + " ");
        	 node = node.next;
         }
         System.out.println();
	}
	
	//ͷ�巨����������
	public void createLinkListByHead(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j < n; j++){
			insert(0, sc.next());
		}
	}
	
	//β�巨����������
	public void createLinkListByTail(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j < n; j++){
			insert(length(), sc.next());
		}
	}

}
