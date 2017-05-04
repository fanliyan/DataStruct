package dataStruct.danlianbiao;

import java.util.Scanner;

import dataStruct.IXianxingbiao.IList;

/**
 * 带头结点
 * @author 范立炎
 *
 */
public class LinkList implements IList {

	public Node head;    
	
	public LinkList() {
		head = new Node();
	}
	
	public LinkList(int n, boolean order) throws Exception{         //构造长度为n单链表
		this();           //初始化头结点
		if(order){
			createLinkListByTail(n);         //尾插法建立单链表
		}else{
			createLinkListByHead(n); 		//头插法建立单链表
		}
	}
	
	@Override
	public void clear() {
       head.next = null;
       head.data = null;
	}

	//判断带头结点的单链表是否为空
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	//带头结点单链表长度
	@Override
	public int length() {
		Node p = head.next;    //初始化p为首结点
		int length = 0;   		//计数器
		while(p != null){
			p = p.next;
			++length;
		}
		return length;
	}

	//读取带头结点的单链表的第i个结点
	@Override
	public Object get(int i) throws Exception {
		Node p = head.next;
		int j = 0;
		while(p != null && j < i){
			p = p.next;
			++j;
		}
		if(j > i || p == null){
			throw new Exception("第" + i + "个元素不存在");
		}
		return p.data;
	}

	//带头结点单链表插入操作
	@Override
	public void insert(int i, Object x) throws Exception {
		Node p = head;    //初始化p为头结点
		int j = -1;       // j为计数器
		while(p != null && j < i - 1){
			p = p.next;
			++j;
		}
		if(j > i - 1 || p == null){
			throw new Exception("插入位置不合法");
		}  
		Node s = new Node(x);   //生成新结点
		s.next = p.next;
		p.next = s;
	}

	//读取带头结点的单链表的第i个结点
	@Override
	public void remove(int i) throws Exception {
          Node p = head; //初始化p为头结点
          int j = -1;
          while(p.next != null && j < i - 1){
        	 p = p.next;
        	  ++j;
          }
          if(j > i - 1 || p == null){
        	  throw new Exception("删除位置不合法");
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
	
	//头插法创建单链表
	public void createLinkListByHead(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j < n; j++){
			insert(0, sc.next());
		}
	}
	
	//尾插法创建单链表
	public void createLinkListByTail(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j < n; j++){
			insert(length(), sc.next());
		}
	}

}
